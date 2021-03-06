/*
 * Copyright 2011 BetaSteward_at_googlemail.com. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of BetaSteward_at_googlemail.com.
 */
package mage.deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mage.abilities.common.CanBeYourCommanderAbility;
import mage.abilities.keyword.PartnerAbility;
import mage.cards.Card;
import mage.cards.ExpansionSet;
import mage.cards.Sets;
import mage.cards.decks.Constructed;
import mage.cards.decks.Deck;
import mage.constants.CardType;
import mage.constants.SetType;
import mage.filter.FilterMana;
import mage.util.CardUtil;

/**
 *
 * @author Plopman
 */
public class Commander extends Constructed {

    protected List<String> bannedCommander = new ArrayList<>();

    public Commander() {
        this("Commander");
        for (ExpansionSet set : Sets.getInstance().values()) {
            if (set.getSetType() != SetType.CUSTOM_SET) {
                setCodes.add(set.getCode());
            }
        }
        banned.add("Ancestral Recall");
        banned.add("Balance");
        banned.add("Biorhythm");
        banned.add("Black Lotus");
        banned.add("Braids, Cabal Minion");
        banned.add("Channel");
        banned.add("Coalition Victory");
        banned.add("Emrakul, the Aeons Torn");
        banned.add("Erayo, Soratami Ascendant");
        banned.add("Fastbond");
        banned.add("Gifts Ungiven");
        banned.add("Griselbrand");
        banned.add("Karakas");
        banned.add("Library of Alexandria");
        banned.add("Limited Resources");
        banned.add("Mox Emerald");
        banned.add("Mox Jet");
        banned.add("Mox Pearl");
        banned.add("Mox Ruby");
        banned.add("Mox Sapphire");
        banned.add("Painter's Servant");
        banned.add("Panoptic Mirror");
        banned.add("Primeval Titan");
        banned.add("Prophet of Kruphix");
        banned.add("Protean Hulk");
        banned.add("Recurring Nightmare");
        banned.add("Rofellos, Llanowar Emissary");
        banned.add("Sundering Titan");
        banned.add("Sway of the Stars");
        banned.add("Sylvan Primordial");
        banned.add("Time Vault");
        banned.add("Time Walk");
        banned.add("Tinker");
        banned.add("Tolarian Academy");
        banned.add("Trade Secrets");
        banned.add("Upheaval");
        banned.add("Worldfire");
        banned.add("Yawgmoth's Bargain");
    }

    public Commander(String name) {
        super(name);
    }

    @Override
    public boolean validate(Deck deck) {
        boolean valid = true;
        FilterMana colorIdentity = new FilterMana();

        if (deck.getCards().size() + deck.getSideboard().size() != 100) {
            invalid.put("Deck", "Must contain 100 cards: has " + (deck.getCards().size() + deck.getSideboard().size()) + " cards");
            valid = false;
        }

        List<String> basicLandNames = new ArrayList<>(Arrays.asList("Forest", "Island", "Mountain", "Swamp", "Plains", "Wastes",
                "Snow-Covered Forest", "Snow-Covered Island", "Snow-Covered Mountain", "Snow-Covered Swamp", "Snow-Covered Plains"));
        Map<String, Integer> counts = new HashMap<>();
        countCards(counts, deck.getCards());
        countCards(counts, deck.getSideboard());
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                if (!basicLandNames.contains(entry.getKey()) && !entry.getKey().equals("Relentless Rats") && !entry.getKey().equals("Shadowborn Apostle")) {
                    invalid.put(entry.getKey(), "Too many: " + entry.getValue());
                    valid = false;
                }
            }
        }

        for (String bannedCard : banned) {
            if (counts.containsKey(bannedCard)) {
                invalid.put(bannedCard, "Banned");
                valid = false;
            }
        }

        if (deck.getSideboard().size() < 1 || deck.getSideboard().size() > 2) {
            invalid.put("Commander", "Sideboard must contain only the commander(s)");
            valid = false;
        } else {
            for (Card commander : deck.getSideboard()) {
                if (bannedCommander.contains(commander.getName())) {
                    invalid.put("Commander", "Commander banned (" + commander.getName() + ")");
                    valid = false;
                }
                if ((!commander.getCardType().contains(CardType.CREATURE) || !commander.getSupertype().contains("Legendary"))
                        && (!commander.getCardType().contains(CardType.PLANESWALKER) || !commander.getAbilities().contains(CanBeYourCommanderAbility.getInstance()))) {
                    invalid.put("Commander", "Commander invalid (" + commander.getName() + ")");
                    valid = false;
                }
                if (deck.getSideboard().size() == 2 && !commander.getAbilities().contains(PartnerAbility.getInstance())) {
                    invalid.put("Commander", "Commander without Partner (" + commander.getName() + ")");
                    valid = false;
                }
                FilterMana commanderColor = CardUtil.getColorIdentity(commander);
                if (commanderColor.isWhite()) {
                    colorIdentity.setWhite(true);
                }
                if (commanderColor.isBlue()) {
                    colorIdentity.setBlue(true);
                }
                if (commanderColor.isBlack()) {
                    colorIdentity.setBlack(true);
                }
                if (commanderColor.isRed()) {
                    colorIdentity.setRed(true);
                }
                if (commanderColor.isGreen()) {
                    colorIdentity.setGreen(true);
                }
            }
        }
        for (Card card : deck.getCards()) {
            if (!cardHasValidColor(colorIdentity, card)) {
                invalid.put(card.getName(), "Invalid color (" + colorIdentity.toString() + ")");
                valid = false;
            }
        }
        for (Card card : deck.getCards()) {
            if (!isSetAllowed(card.getExpansionSetCode())) {
                if (!legalSets(card)) {
                    invalid.put(card.getName(), "Not allowed Set: " + card.getExpansionSetCode());
                    valid = false;
                }
            }
        }
        for (Card card : deck.getSideboard()) {
            if (!isSetAllowed(card.getExpansionSetCode())) {
                if (!legalSets(card)) {
                    invalid.put(card.getName(), "Not allowed Set: " + card.getExpansionSetCode());
                    valid = false;
                }
            }
        }
        return valid;
    }

    public boolean cardHasValidColor(FilterMana commander, Card card) {
        FilterMana cardColor = CardUtil.getColorIdentity(card);
        return !(cardColor.isBlack() && !commander.isBlack()
                || cardColor.isBlue() && !commander.isBlue()
                || cardColor.isGreen() && !commander.isGreen()
                || cardColor.isRed() && !commander.isRed()
                || cardColor.isWhite() && !commander.isWhite());
    }

    @Override
    public int getEdhPowerLevel(Deck deck) {
        if (deck == null) {
            return 0;
        }

        int edhPowerLevel = 0;
        for (Card card : deck.getCards()) {

            int thisMaxPower = 0;

            // Examine rules to work out most egregious functions in edh
            boolean anyNumberOfTarget = false;
            boolean buyback = false;
            boolean cascade = false;
            boolean copy = false;
            boolean exile = false;
            boolean exileAll = false;
            boolean counter = false;
            boolean destroy = false;
            boolean destroyAll = false;
            boolean each = false;
            boolean exalted = false;
            boolean drawCards = false;
            boolean extraTurns = false;
            boolean gainControl = false;
            boolean infect = false;
            boolean mayCastForFree = false;
            boolean miracle = false;
            boolean overload = false;
            boolean persist = false;
            boolean proliferate = false;
            boolean retrace = false;
            boolean sacrifice = false;
            boolean skip = false;
            boolean sliver = false;
            boolean tutor = false;
            boolean undying = false;
            boolean wheneverEnters = false;
            boolean youControlTarget = false;

            for (String str : card.getRules()) {
                String s = str.toLowerCase();
                anyNumberOfTarget |= s.contains("any number");
                buyback |= s.contains("buyback");
                cascade |= s.contains("cascade");
                copy |= s.contains("copy");
                counter |= s.contains("counter") && s.contains("target");
                destroy |= s.contains("destroy");
                destroyAll |= s.contains("destroy all");
                drawCards |= s.contains("draw cards");
                each |= s.contains("each");
                exalted |= s.contains("exalted");
                exile |= s.contains("exile");
                exileAll |= s.contains("exile") && s.contains(" all ");
                extraTurns |= s.contains("extra turn");
                gainControl |= s.contains("gain control");
                infect |= s.contains("infect");
                mayCastForFree |= s.contains("may cast") && s.contains("without paying");
                miracle |= s.contains("miracle");
                overload |= s.contains("overload");
                persist |= s.contains("persist");
                proliferate |= s.contains("proliferate");
                retrace |= s.contains("retrace");
                sacrifice |= s.contains("sacrifice");
                skip |= s.contains("skip") && s.contains("each");
                sliver |= s.contains("sliver");
                tutor |= s.contains("search your library");
                undying |= s.contains("undying");
                wheneverEnters |= s.contains("when") && s.contains("another") && s.contains("enters");
                youControlTarget |= s.contains("you control target");
            }

            if (extraTurns) {
                thisMaxPower = Math.max(thisMaxPower, 7);
            }
            if (buyback) {
                thisMaxPower = Math.max(thisMaxPower, 6);
            }
            if (tutor) {
                thisMaxPower = Math.max(thisMaxPower, 6);
            }
            if (infect) {
                thisMaxPower = Math.max(thisMaxPower, 5);
            }
            if (overload) {
                thisMaxPower = Math.max(thisMaxPower, 5);
            }
            if (cascade) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (each) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (exileAll) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (gainControl) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (mayCastForFree) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (proliferate) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (skip) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (wheneverEnters) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (youControlTarget) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }
            if (anyNumberOfTarget) {
                thisMaxPower = Math.max(thisMaxPower, 3);
            }
            if (destroyAll) {
                thisMaxPower = Math.max(thisMaxPower, 3);
            }
            if (undying) {
                thisMaxPower = Math.max(thisMaxPower, 3);
            }
            if (persist) {
                thisMaxPower = Math.max(thisMaxPower, 3);
            }
            if (exile) {
                thisMaxPower = Math.max(thisMaxPower, 2);
            }
            if (miracle) {
                thisMaxPower = Math.max(thisMaxPower, 2);
            }
            if (sliver) {
                thisMaxPower = Math.max(thisMaxPower, 2);
            }
            if (sacrifice) {
                thisMaxPower = Math.max(thisMaxPower, 2);
            }
            if (copy) {
                thisMaxPower = Math.max(thisMaxPower, 1);
            }
            if (counter) {
                thisMaxPower = Math.max(thisMaxPower, 1);
            }
            if (destroy) {
                thisMaxPower = Math.max(thisMaxPower, 1);
            }
            if (drawCards) {
                thisMaxPower = Math.max(thisMaxPower, 1);
            }
            if (exalted) {
                thisMaxPower = Math.max(thisMaxPower, 1);
            }
            if (retrace) {
                thisMaxPower = Math.max(thisMaxPower, 1);
            }

            // Planeswalkers
            if (card.getCardType().contains(CardType.PLANESWALKER)) {
                if (card.getName().toLowerCase().equals("jace, the mind sculptor")) {
                    thisMaxPower = Math.max(thisMaxPower, 5);
                }
                thisMaxPower = Math.max(thisMaxPower, 3);
            }

            if (card.getCardType().contains(CardType.LAND)) {
                thisMaxPower = 0;
            }

            // Banned in french or unfair cards
            String cn = card.getName().toLowerCase();
            if (cn.equals("ancient tomb")
                    || cn.equals("anafenza, the foremost")
                    || cn.equals("arcum dagsson")
                    || cn.equals("armageddon")
                    || cn.equals("aura shards")
                    || cn.equals("azami, lady of scrolls")
                    || cn.equals("azusa, lost but seeking")
                    || cn.equals("back to basics")
                    || cn.equals("bane of progress")
                    || cn.equals("basalt monolith")
                    || cn.equals("blightsteel collossus")
                    || cn.equals("braids, cabal minion")
                    || cn.equals("cabal coffers")
                    || cn.equals("captain sisay")
                    || cn.equals("celestial dawn")
                    || cn.equals("child of alara")
                    || cn.equals("coalition relic")
                    || cn.equals("craterhoof behemoth")
                    || cn.equals("deepglow skate")
                    || cn.equals("derevi, empyrial tactician")
                    || cn.equals("dig through time")
                    || cn.equals("edric, spymaster of trest")
                    || cn.equals("elesh norn, grand cenobite")
                    || cn.equals("entomb")
                    || cn.equals("food chain")
                    || cn.equals("gaddock teeg")
                    || cn.equals("gaea's cradle")
                    || cn.equals("grand arbiter augustin iv")
                    || cn.equals("grim monolith")
                    || cn.equals("hermit druid")
                    || cn.equals("hokori, dust drinker")
                    || cn.equals("humility")
                    || cn.equals("imperial seal")
                    || cn.equals("iona, shield of emeria")
                    || cn.equals("jin-gitaxias, core augur")
                    || cn.equals("karador, ghost chieftain")
                    || cn.equals("karakas")
                    || cn.equals("kataki, war's wage")
                    || cn.equals("knowledge pool")
                    || cn.equals("linvala, keeper of silence")
                    || cn.equals("living death")
                    || cn.equals("llawan, cephalid empress")
                    || cn.equals("loyal retainers")
                    || cn.equals("maelstrom wanderer")
                    || cn.equals("malfegor")
                    || cn.equals("mana crypt")
                    || cn.equals("mana drain")
                    || cn.equals("mana vault")
                    || cn.equals("michiko konda, truth seeker")
                    || cn.equals("nath of the gilt-leaf")
                    || cn.equals("natural order")
                    || cn.equals("necrotic ooze")
                    || cn.equals("nicol bolas")
                    || cn.equals("numot, the devastator")
                    || cn.equals("oath of druids")
                    || cn.equals("pattern of rebirth")
                    || cn.equals("protean hulk")
                    || cn.equals("purphoros, god of the forge")
                    || cn.equals("ravages of war")
                    || cn.equals("reclamation sage")
                    || cn.equals("sen triplets")
                    || cn.equals("serra's sanctum")
                    || cn.equals("sheoldred, whispering one")
                    || cn.equals("sol ring")
                    || cn.equals("spore frog")
                    || cn.equals("stasis")
                    || cn.equals("strip mine")
                    || cn.equals("the tabernacle at pendrell vale")
                    || cn.equals("tinker")
                    || cn.equals("tolarian academy")
                    || cn.equals("treasure cruise")
                    || cn.equals("urabrask the hidden")
                    || cn.equals("vorinclex, voice of hunger")
                    || cn.equals("winter orb")
                    || cn.equals("zur the enchanter")) {
                thisMaxPower = Math.max(thisMaxPower, 4);
            }

            // Parts of infinite combos
            if (cn.equals("animate artifact") || cn.equals("archaeomancer")
                    || cn.equals("ashnod's altar") || cn.equals("azami, lady of scrolls")
                    || cn.equals("basalt monolith") || cn.equals("brago, king eternal")
                    || cn.equals("candelabra of tawnos") || cn.equals("cephalid aristocrat")
                    || cn.equals("cephalid illusionist") || cn.equals("changeling berserker")
                    || cn.equals("cinderhaze wretch") || cn.equals("cryptic gateway")
                    || cn.equals("deadeye navigator") || cn.equals("derevi, empyrial tactician")
                    || cn.equals("doubling season") || cn.equals("dross scorpion")
                    || cn.equals("earthcraft") || cn.equals("erratic portal")
                    || cn.equals("enter the infinite") || cn.equals("omniscience")
                    || cn.equals("exquisite blood") || cn.equals("future sight")
                    || cn.equals("grave titan") || cn.equals("great whale")
                    || cn.equals("grim monolith") || cn.equals("gush")
                    || cn.equals("hellkite charger") || cn.equals("intruder alarm")
                    || cn.equals("iona, shield of emeria")
                    || cn.equals("karn, silver golem") || cn.equals("kiki-jiki, mirror breaker")
                    || cn.equals("krark-clan ironworks") || cn.equals("krenko, mob boss")
                    || cn.equals("krosan restorer") || cn.equals("laboratory maniac")
                    || cn.equals("leovold, emissary of trest")
                    || cn.equals("leonin relic-warder") || cn.equals("leyline of the void")
                    || cn.equals("memnarch") || cn.equals("memnarch")
                    || cn.equals("meren of clan nel toth") || cn.equals("mikaeus, the unhallowed")
                    || cn.equals("mindcrank") || cn.equals("mindslaver")
                    || cn.equals("minion reflector") || cn.equals("mycosynth lattice")
                    || cn.equals("myr turbine") || cn.equals("narset, enlightened master")
                    || cn.equals("nekusar, the mindrazer") || cn.equals("norin the wary")
                    || cn.equals("opalescence") || cn.equals("ornithopter")
                    || cn.equals("planar portal") || cn.equals("power artifact")
                    || cn.equals("rings of brighthearth") || cn.equals("rite of replication")
                    || cn.equals("sanguine bond") || cn.equals("sensei's divining top")
                    || cn.equals("splinter twin") || cn.equals("stony silence")
                    || cn.equals("storm cauldron") || cn.equals("teferi's puzzle box")
                    || cn.equals("teferi, mage of zhalfir") || cn.equals("teferi, mage of zhalfir")
                    || cn.equals("tezzeret the seeker") || cn.equals("time stretch")
                    || cn.equals("time warp") || cn.equals("training grounds")
                    || cn.equals("triskelavus") || cn.equals("triskelion")
                    || cn.equals("turnabout") || cn.equals("umbral mantle")
                    || cn.equals("uyo, silent prophet") || cn.equals("voltaic key")
                    || cn.equals("workhorse") || cn.equals("worldgorger dragon")
                    || cn.equals("worthy cause") || cn.equals("yawgmoth's will")
                    || cn.equals("zealous conscripts")) {
                thisMaxPower = Math.max(thisMaxPower, 6);
            }
            edhPowerLevel += thisMaxPower;
        }

        for (Card commander : deck.getSideboard()) {
            int thisMaxPower = 0;
            String cn = commander.getName().toLowerCase();

            // Least fun commanders
            if (cn.equals("azami, lady of scrolls")
                || cn.equals("braids, cabal minion")
                || cn.equals("child of alara")
                || cn.equals("derevi, empyrial tactician")
                || cn.equals("edric, spymaster of trest")
                || cn.equals("gaddock teeg")
                || cn.equals("grand arbiter augustin iv")
                || cn.equals("hokori, dust drinker")
                || cn.equals("iona, shield of emeria")
                || cn.equals("jin-gitaxias, core augur")
                || cn.equals("karador, ghost chieftain")
                || cn.equals("leovold, emissary of trest")
                || cn.equals("linvala, keeper of silence")
                || cn.equals("llawan, cephalid empress")
                || cn.equals("memnarch")
                || cn.equals("meren of clan nel toth")
                || cn.equals("michiko konda, truth seeker")
                || cn.equals("narset, enlightened master")
                || cn.equals("nekusar, the mindrazer")
                || cn.equals("norin the wary")
                || cn.equals("numot, the devastator")
                || cn.equals("sheoldred, whispering one")
                || cn.equals("teferi, mage of zhalfir")
                || cn.equals("zur the enchanter")) {
                thisMaxPower = Math.max(thisMaxPower, 15);
            }

            // Next least fun commanders
            if (cn.equals("anafenza, the foremost")
                || cn.equals("arcum dagsson")
                || cn.equals("azusa, lost but seeking")
                || cn.equals("brago, king eternal")
                || cn.equals("captain sisay")
                || cn.equals("elesh norn, grand cenobite")
                || cn.equals("malfegor")
                || cn.equals("maelstrom wanderer")
                || cn.equals("mikaeus the unhallowed")
                || cn.equals("nath of the gilt-leaf")
                || cn.equals("purphoros, god of the forge")
                || cn.equals("sen triplets")
                || cn.equals("urabrask the hidden")
                || cn.equals("vorinclex, voice of hunger")) {
                thisMaxPower = Math.max(thisMaxPower, 10);
            }
            edhPowerLevel += thisMaxPower;
        }

        edhPowerLevel = (int) Math.round(edhPowerLevel / 2.5);
        if (edhPowerLevel > 100) {
            edhPowerLevel = 100;
        }
        return edhPowerLevel;
    }
}
