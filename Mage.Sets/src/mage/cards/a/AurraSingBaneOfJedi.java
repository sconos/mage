/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.cards.a;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.LoyaltyAbility;
import mage.abilities.common.LeavesBattlefieldAllTriggeredAbility;
import mage.abilities.common.PlanswalkerEntersWithLoyalityCountersAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.DamageControllerEffect;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.effects.common.GetEmblemTargetPlayerEffect;
import mage.abilities.effects.common.SetPlayerLifeAllEffect;
import mage.abilities.effects.common.discard.DiscardControllerEffect;
import mage.abilities.effects.common.discard.DiscardHandAllEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.choices.Choice;
import mage.choices.ChoiceImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.permanent.TokenPredicate;
import mage.game.Game;
import mage.game.command.Emblem;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.TargetPlayer;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author Styxo
 */
public class AurraSingBaneOfJedi extends CardImpl {

    public AurraSingBaneOfJedi(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.PLANESWALKER},"{2}{B}{R}");
        this.subtype.add("Aurra");

        this.addAbility(new PlanswalkerEntersWithLoyalityCountersAbility(3));

        // +1:Aurra Sing deals 2 damage to target creature or 1 damage to you.
        Ability ability = new LoyaltyAbility(new AurraSingBaneOfJediEffect(), +1);
        ability.addTarget(new TargetCreaturePermanent(1));
        this.addAbility(ability);

        // -4:Target player gets an emblem wiht "Whenever a nontoken creature you control leave the battlefied, discard a card.".
        ability = new LoyaltyAbility(new GetEmblemTargetPlayerEffect(new AurraSingBaneOfJediEmblem()), -4);
        ability.addTarget(new TargetPlayer());
        this.addAbility(ability);

        // -6:Each player discards his or her hand and sacrificies all creatures he or she controls. Each player's life total becomes 1."
        ability = new LoyaltyAbility(new DiscardHandAllEffect(), -6);
        ability.addEffect(new SacrificeAllEffect());
        Effect effect = new SetPlayerLifeAllEffect(1, TargetController.ANY);
        ability.addEffect(effect);
        this.addAbility(ability);
    }

    public AurraSingBaneOfJedi(final AurraSingBaneOfJedi card) {
        super(card);
    }

    @Override
    public AurraSingBaneOfJedi copy() {
        return new AurraSingBaneOfJedi(this);
    }
}

class AurraSingBaneOfJediEffect extends OneShotEffect {

    private static final HashSet<String> choices = new HashSet<>();

    static {
        choices.add("Deal 2 damage to target creature");
        choices.add("Deal 1 damage to you");
    }

    public AurraSingBaneOfJediEffect() {
        super(Outcome.Damage);
        staticText = "{this} deals 2 damage to target creature or 1 damage to you";
    }

    public AurraSingBaneOfJediEffect(final AurraSingBaneOfJediEffect effect) {
        super(effect);
    }

    @Override
    public AurraSingBaneOfJediEffect copy() {
        return new AurraSingBaneOfJediEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        if (controller != null) {
            Choice choice = new ChoiceImpl(true);
            choice.setMessage("Choose mode");
            choice.setChoices(choices);
            while (!controller.choose(outcome, choice, game)) {
                if (!controller.canRespond()) {
                    return false;
                }
            }

            String chosen = choice.getChoice();
            switch (chosen) {
                case "Deal 2 damage to target creature":
                    new DamageTargetEffect(2).apply(game, source);
                    break;
                default: //"Deal 1 damage to you"
                    new DamageControllerEffect(1).apply(game, source);
                    break;
            }
            return true;
        }
        return false;
    }
}

class SacrificeAllEffect extends OneShotEffect {

    SacrificeAllEffect() {
        super(Outcome.DestroyPermanent);
        staticText = "and sacrificies all creatures he or she controls";
    }

    SacrificeAllEffect(final SacrificeAllEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        List<Permanent> permanents = game.getBattlefield().getActivePermanents(new FilterCreaturePermanent(), source.getControllerId(), source.getId(), game);
        for (Permanent p : permanents) {
            p.sacrifice(source.getSourceId(), game);
        }
        return true;
    }

    @Override
    public SacrificeAllEffect copy() {
        return new SacrificeAllEffect(this);
    }
}

class AurraSingBaneOfJediEmblem extends Emblem {

    private static final FilterControlledCreaturePermanent filter = new FilterControlledCreaturePermanent("a nontoken creature you control");

    static {
        filter.add(Predicates.not(new TokenPredicate()));
    }

    //  Whenever a nontoken creature you control leave the battlefied, discard a card."
    public AurraSingBaneOfJediEmblem() {
        this.setName("Emblem - Aurra");
        getAbilities().add(new LeavesBattlefieldAllTriggeredAbility(Zone.COMMAND, new DiscardControllerEffect(1), filter, false));
    }
}
