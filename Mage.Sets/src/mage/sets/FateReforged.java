/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
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
package mage.sets;

import java.util.ArrayList;
import java.util.List;
import mage.cards.ExpansionSet;
import mage.cards.repository.CardCriteria;
import mage.cards.repository.CardInfo;
import mage.cards.repository.CardRepository;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.SetType;
import mage.cards.CardGraphicInfo;

/**
 *
 * @author fireshoes
 */
public class FateReforged extends ExpansionSet {

    private static final FateReforged fINSTANCE = new FateReforged();

    List<CardInfo> savedSpecialRares = new ArrayList<>();
    List<CardInfo> savedSpecialCommon = new ArrayList<>();

    public static FateReforged getInstance() {
        return fINSTANCE;
    }

    private FateReforged() {
        super("Fate Reforged", "FRF", ExpansionSet.buildDate(2015, 1, 23), SetType.EXPANSION);
        this.blockName = "Khans of Tarkir";
        this.parentSet = KhansOfTarkir.getInstance();
        this.hasBasicLands = false;
        this.hasBoosters = true;
        this.numBoosterSpecial = 1;
        this.numBoosterLands = 0;
        this.numBoosterCommon = 10;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.numBoosterDoubleFaced = -1;
        this.ratioBoosterMythic = 8;
        cards.add(new SetCardInfo("Abzan Advantage", 2, Rarity.COMMON, mage.cards.a.AbzanAdvantage.class));
        cards.add(new SetCardInfo("Abzan Beastmaster", 119, Rarity.UNCOMMON, mage.cards.a.AbzanBeastmaster.class));
        cards.add(new SetCardInfo("Abzan Kin-Guard", 120, Rarity.UNCOMMON, mage.cards.a.AbzanKinGuard.class));
        cards.add(new SetCardInfo("Abzan Runemark", 3, Rarity.COMMON, mage.cards.a.AbzanRunemark.class));
        cards.add(new SetCardInfo("Abzan Skycaptain", 4, Rarity.COMMON, mage.cards.a.AbzanSkycaptain.class));
        cards.add(new SetCardInfo("Ainok Guide", 121, Rarity.COMMON, mage.cards.a.AinokGuide.class));
        cards.add(new SetCardInfo("Alesha's Vanguard", 60, Rarity.COMMON, mage.cards.a.AleshasVanguard.class));
        cards.add(new SetCardInfo("Alesha, Who Smiles at Death", 90, Rarity.RARE, mage.cards.a.AleshaWhoSmilesAtDeath.class));
        cards.add(new SetCardInfo("Ambush Krotiq", 122, Rarity.COMMON, mage.cards.a.AmbushKrotiq.class));
        cards.add(new SetCardInfo("Ancestral Vengeance", 61, Rarity.COMMON, mage.cards.a.AncestralVengeance.class));
        cards.add(new SetCardInfo("Arashin Cleric", 5, Rarity.COMMON, mage.cards.a.ArashinCleric.class));
        cards.add(new SetCardInfo("Arashin War Beast", 123, Rarity.UNCOMMON, mage.cards.a.ArashinWarBeast.class));
        cards.add(new SetCardInfo("Arcbond", 91, Rarity.RARE, mage.cards.a.Arcbond.class));
        cards.add(new SetCardInfo("Archers of Qarsi", 124, Rarity.COMMON, mage.cards.a.ArchersOfQarsi.class));
        cards.add(new SetCardInfo("Archfiend of Depravity", 62, Rarity.RARE, mage.cards.a.ArchfiendOfDepravity.class));
        cards.add(new SetCardInfo("Atarka, World Render", 149, Rarity.RARE, mage.cards.a.AtarkaWorldRender.class));
        cards.add(new SetCardInfo("Aven Skirmisher", 6, Rarity.COMMON, mage.cards.a.AvenSkirmisher.class));
        cards.add(new SetCardInfo("Aven Surveyor", 31, Rarity.COMMON, mage.cards.a.AvenSurveyor.class));
        cards.add(new SetCardInfo("Bathe in Dragonfire", 92, Rarity.COMMON, mage.cards.b.BatheInDragonfire.class));
        cards.add(new SetCardInfo("Battle Brawler", 63, Rarity.UNCOMMON, mage.cards.b.BattleBrawler.class));
        cards.add(new SetCardInfo("Battlefront Krushok", 125, Rarity.UNCOMMON, mage.cards.b.BattlefrontKrushok.class));
        cards.add(new SetCardInfo("Bloodfell Caves", 165, Rarity.COMMON, mage.cards.b.BloodfellCaves.class));
        cards.add(new SetCardInfo("Bloodfire Enforcers", 93, Rarity.UNCOMMON, mage.cards.b.BloodfireEnforcers.class));
        cards.add(new SetCardInfo("Blossoming Sands", 166, Rarity.COMMON, mage.cards.b.BlossomingSands.class));
        cards.add(new SetCardInfo("Break Through the Line", 94, Rarity.UNCOMMON, mage.cards.b.BreakThroughTheLine.class));
        cards.add(new SetCardInfo("Brutal Hordechief", 64, Rarity.MYTHIC, mage.cards.b.BrutalHordechief.class));
        cards.add(new SetCardInfo("Cached Defenses", 126, Rarity.UNCOMMON, mage.cards.c.CachedDefenses.class));
        cards.add(new SetCardInfo("Channel Harm", 7, Rarity.UNCOMMON, mage.cards.c.ChannelHarm.class));
        cards.add(new SetCardInfo("Citadel Siege", 8, Rarity.RARE, mage.cards.c.CitadelSiege.class));
        cards.add(new SetCardInfo("Cloudform", 32, Rarity.UNCOMMON, mage.cards.c.Cloudform.class));
        cards.add(new SetCardInfo("Collateral Damage", 95, Rarity.COMMON, mage.cards.c.CollateralDamage.class));
        cards.add(new SetCardInfo("Crucible of the Spirit Dragon", 167, Rarity.RARE, mage.cards.c.CrucibleOfTheSpiritDragon.class));
        cards.add(new SetCardInfo("Crux of Fate", 65, Rarity.RARE, mage.cards.c.CruxOfFate.class));
        cards.add(new SetCardInfo("Cunning Strike", 150, Rarity.COMMON, mage.cards.c.CunningStrike.class));
        cards.add(new SetCardInfo("Daghatar the Adamant", 9, Rarity.RARE, mage.cards.d.DaghatarTheAdamant.class));
        cards.add(new SetCardInfo("Dark Deal", 66, Rarity.UNCOMMON, mage.cards.d.DarkDeal.class));
        cards.add(new SetCardInfo("Defiant Ogre", 96, Rarity.COMMON, mage.cards.d.DefiantOgre.class));
        cards.add(new SetCardInfo("Destructor Dragon", 127, Rarity.UNCOMMON, mage.cards.d.DestructorDragon.class));
        cards.add(new SetCardInfo("Diplomacy of the Wastes", 67, Rarity.UNCOMMON, mage.cards.d.DiplomacyOfTheWastes.class));
        cards.add(new SetCardInfo("Dismal Backwater", 168, Rarity.COMMON, mage.cards.d.DismalBackwater.class));
        cards.add(new SetCardInfo("Douse in Gloom", 68, Rarity.COMMON, mage.cards.d.DouseInGloom.class));
        cards.add(new SetCardInfo("Dragon Bell Monk", 10, Rarity.COMMON, mage.cards.d.DragonBellMonk.class));
        cards.add(new SetCardInfo("Dragonrage", 97, Rarity.UNCOMMON, mage.cards.d.Dragonrage.class));
        cards.add(new SetCardInfo("Dragonscale General", 11, Rarity.RARE, mage.cards.d.DragonscaleGeneral.class));
        cards.add(new SetCardInfo("Dromoka, the Eternal", 151, Rarity.RARE, mage.cards.d.DromokaTheEternal.class));
        cards.add(new SetCardInfo("Elite Scaleguard", 12, Rarity.UNCOMMON, mage.cards.e.EliteScaleguard.class));
        cards.add(new SetCardInfo("Enhanced Awareness", 33, Rarity.COMMON, mage.cards.e.EnhancedAwareness.class));
        cards.add(new SetCardInfo("Ethereal Ambush", 152, Rarity.COMMON, mage.cards.e.EtherealAmbush.class));
        cards.add(new SetCardInfo("Fascination", 34, Rarity.UNCOMMON, mage.cards.f.Fascination.class));
        cards.add(new SetCardInfo("Fearsome Awakening", 69, Rarity.UNCOMMON, mage.cards.f.FearsomeAwakening.class));
        cards.add(new SetCardInfo("Feral Krushok", 128, Rarity.COMMON, mage.cards.f.FeralKrushok.class));
        cards.add(new SetCardInfo("Fierce Invocation", 98, Rarity.COMMON, mage.cards.f.FierceInvocation.class));
        cards.add(new SetCardInfo("Flamerush Rider", 99, Rarity.RARE, mage.cards.f.FlamerushRider.class));
        cards.add(new SetCardInfo("Flamewake Phoenix", 100, Rarity.RARE, mage.cards.f.FlamewakePhoenix.class));
        cards.add(new SetCardInfo("Forest", 184, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Forest", 185, Rarity.LAND, mage.cards.basiclands.Forest.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Formless Nurturing", 129, Rarity.COMMON, mage.cards.f.FormlessNurturing.class));
        cards.add(new SetCardInfo("Friendly Fire", 101, Rarity.UNCOMMON, mage.cards.f.FriendlyFire.class));
        cards.add(new SetCardInfo("Frontier Mastodon", 130, Rarity.COMMON, mage.cards.f.FrontierMastodon.class));
        cards.add(new SetCardInfo("Frontier Siege", 131, Rarity.RARE, mage.cards.f.FrontierSiege.class));
        cards.add(new SetCardInfo("Frost Walker", 35, Rarity.UNCOMMON, mage.cards.f.FrostWalker.class));
        cards.add(new SetCardInfo("Fruit of the First Tree", 132, Rarity.UNCOMMON, mage.cards.f.FruitOfTheFirstTree.class));
        cards.add(new SetCardInfo("Ghastly Conscription", 70, Rarity.MYTHIC, mage.cards.g.GhastlyConscription.class));
        cards.add(new SetCardInfo("Goblin Boom Keg", 159, Rarity.UNCOMMON, mage.cards.g.GoblinBoomKeg.class));
        cards.add(new SetCardInfo("Goblin Heelcutter", 102, Rarity.COMMON, mage.cards.g.GoblinHeelcutter.class));
        cards.add(new SetCardInfo("Gore Swine", 103, Rarity.COMMON, mage.cards.g.GoreSwine.class));
        cards.add(new SetCardInfo("Grave Strength", 71, Rarity.UNCOMMON, mage.cards.g.GraveStrength.class));
        cards.add(new SetCardInfo("Great-Horn Krushok", 13, Rarity.COMMON, mage.cards.g.GreatHornKrushok.class));
        cards.add(new SetCardInfo("Grim Contest", 153, Rarity.COMMON, mage.cards.g.GrimContest.class));
        cards.add(new SetCardInfo("Gurmag Angler", 72, Rarity.COMMON, mage.cards.g.GurmagAngler.class));
        cards.add(new SetCardInfo("Harsh Sustenance", 154, Rarity.COMMON, mage.cards.h.HarshSustenance.class));
        cards.add(new SetCardInfo("Hero's Blade", 160, Rarity.UNCOMMON, mage.cards.h.HerosBlade.class));
        cards.add(new SetCardInfo("Hewed Stone Retainers", 161, Rarity.UNCOMMON, mage.cards.h.HewedStoneRetainers.class));
        cards.add(new SetCardInfo("Honor's Reward", 14, Rarity.UNCOMMON, mage.cards.h.HonorsReward.class));
        cards.add(new SetCardInfo("Hooded Assassin", 73, Rarity.COMMON, mage.cards.h.HoodedAssassin.class));
        cards.add(new SetCardInfo("Humble Defector", 104, Rarity.UNCOMMON, mage.cards.h.HumbleDefector.class));
        cards.add(new SetCardInfo("Hungering Yeti", 105, Rarity.UNCOMMON, mage.cards.h.HungeringYeti.class));
        cards.add(new SetCardInfo("Hunt the Weak", 133, Rarity.COMMON, mage.cards.h.HuntTheWeak.class));
        cards.add(new SetCardInfo("Island", 178, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Island", 179, Rarity.LAND, mage.cards.basiclands.Island.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Jeskai Barricade", 15, Rarity.UNCOMMON, mage.cards.j.JeskaiBarricade.class));
        cards.add(new SetCardInfo("Jeskai Infiltrator", 36, Rarity.RARE, mage.cards.j.JeskaiInfiltrator.class));
        cards.add(new SetCardInfo("Jeskai Runemark", 37, Rarity.COMMON, mage.cards.j.JeskaiRunemark.class));
        cards.add(new SetCardInfo("Jeskai Sage", 38, Rarity.COMMON, mage.cards.j.JeskaiSage.class));
        cards.add(new SetCardInfo("Jungle Hollow", 169, Rarity.COMMON, mage.cards.j.JungleHollow.class));
        cards.add(new SetCardInfo("Kolaghan, the Storm's Fury", 155, Rarity.RARE, mage.cards.k.KolaghanTheStormsFury.class));
        cards.add(new SetCardInfo("Lightform", 16, Rarity.UNCOMMON, mage.cards.l.Lightform.class));
        cards.add(new SetCardInfo("Lightning Shrieker", 106, Rarity.COMMON, mage.cards.l.LightningShrieker.class));
        cards.add(new SetCardInfo("Lotus-Eye Mystics", 17, Rarity.UNCOMMON, mage.cards.l.LotusEyeMystics.class));
        cards.add(new SetCardInfo("Lotus Path Djinn", 39, Rarity.COMMON, mage.cards.l.LotusPathDjinn.class));
        cards.add(new SetCardInfo("Map the Wastes", 134, Rarity.COMMON, mage.cards.m.MapTheWastes.class));
        cards.add(new SetCardInfo("Marang River Prowler", 40, Rarity.UNCOMMON, mage.cards.m.MarangRiverProwler.class));
        cards.add(new SetCardInfo("Mardu Runemark", 107, Rarity.COMMON, mage.cards.m.MarduRunemark.class));
        cards.add(new SetCardInfo("Mardu Scout", 108, Rarity.COMMON, mage.cards.m.MarduScout.class));
        cards.add(new SetCardInfo("Mardu Shadowspear", 74, Rarity.UNCOMMON, mage.cards.m.MarduShadowspear.class));
        cards.add(new SetCardInfo("Mardu Strike Leader", 75, Rarity.RARE, mage.cards.m.MarduStrikeLeader.class));
        cards.add(new SetCardInfo("Mardu Woe-Reaper", 18, Rarity.UNCOMMON, mage.cards.m.MarduWoeReaper.class));
        cards.add(new SetCardInfo("Mastery of the Unseen", 19, Rarity.RARE, mage.cards.m.MasteryOfTheUnseen.class));
        cards.add(new SetCardInfo("Merciless Executioner", 76, Rarity.UNCOMMON, mage.cards.m.MercilessExecutioner.class));
        cards.add(new SetCardInfo("Mindscour Dragon", 41, Rarity.UNCOMMON, mage.cards.m.MindscourDragon.class));
        cards.add(new SetCardInfo("Mistfire Adept", 42, Rarity.UNCOMMON, mage.cards.m.MistfireAdept.class));
        cards.add(new SetCardInfo("Mob Rule", 109, Rarity.RARE, mage.cards.m.MobRule.class));
        cards.add(new SetCardInfo("Monastery Mentor", 20, Rarity.MYTHIC, mage.cards.m.MonasteryMentor.class));
        cards.add(new SetCardInfo("Monastery Siege", 43, Rarity.RARE, mage.cards.m.MonasterySiege.class));
        cards.add(new SetCardInfo("Mountain", 182, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Mountain", 183, Rarity.LAND, mage.cards.basiclands.Mountain.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Neutralizing Blast", 44, Rarity.UNCOMMON, mage.cards.n.NeutralizingBlast.class));
        cards.add(new SetCardInfo("Noxious Dragon", 77, Rarity.UNCOMMON, mage.cards.n.NoxiousDragon.class));
        cards.add(new SetCardInfo("Ojutai, Soul of Winter", 156, Rarity.RARE, mage.cards.o.OjutaiSoulOfWinter.class));
        cards.add(new SetCardInfo("Orc Sureshot", 78, Rarity.UNCOMMON, mage.cards.o.OrcSureshot.class));
        cards.add(new SetCardInfo("Outpost Siege", 110, Rarity.RARE, mage.cards.o.OutpostSiege.class));
        cards.add(new SetCardInfo("Palace Siege", 79, Rarity.RARE, mage.cards.p.PalaceSiege.class));
        cards.add(new SetCardInfo("Pilgrim of the Fires", 162, Rarity.UNCOMMON, mage.cards.p.PilgrimOfTheFires.class));
        cards.add(new SetCardInfo("Plains", 176, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Plains", 177, Rarity.LAND, mage.cards.basiclands.Plains.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Pressure Point", 21, Rarity.COMMON, mage.cards.p.PressurePoint.class));
        cards.add(new SetCardInfo("Pyrotechnics", 111, Rarity.UNCOMMON, mage.cards.p.Pyrotechnics.class));
        cards.add(new SetCardInfo("Qarsi High Priest", 80, Rarity.UNCOMMON, mage.cards.q.QarsiHighPriest.class));
        cards.add(new SetCardInfo("Rageform", 112, Rarity.UNCOMMON, mage.cards.r.Rageform.class));
        cards.add(new SetCardInfo("Rakshasa's Disdain", 45, Rarity.COMMON, mage.cards.r.RakshasasDisdain.class));
        cards.add(new SetCardInfo("Rally the Ancestors", 22, Rarity.RARE, mage.cards.r.RallyTheAncestors.class));
        cards.add(new SetCardInfo("Reach of Shadows", 81, Rarity.COMMON, mage.cards.r.ReachOfShadows.class));
        cards.add(new SetCardInfo("Reality Shift", 46, Rarity.UNCOMMON, mage.cards.r.RealityShift.class));
        cards.add(new SetCardInfo("Refocus", 47, Rarity.COMMON, mage.cards.r.Refocus.class));
        cards.add(new SetCardInfo("Renowned Weaponsmith", 48, Rarity.UNCOMMON, mage.cards.r.RenownedWeaponsmith.class));
        cards.add(new SetCardInfo("Return to the Earth", 135, Rarity.COMMON, mage.cards.r.ReturnToTheEarth.class));
        cards.add(new SetCardInfo("Rite of Undoing", 49, Rarity.UNCOMMON, mage.cards.r.RiteOfUndoing.class));
        cards.add(new SetCardInfo("Rugged Highlands", 170, Rarity.COMMON, mage.cards.r.RuggedHighlands.class));
        cards.add(new SetCardInfo("Ruthless Instincts", 136, Rarity.UNCOMMON, mage.cards.r.RuthlessInstincts.class));
        cards.add(new SetCardInfo("Sage-Eye Avengers", 50, Rarity.RARE, mage.cards.s.SageEyeAvengers.class));
        cards.add(new SetCardInfo("Sage's Reverie", 23, Rarity.UNCOMMON, mage.cards.s.SagesReverie.class));
        cards.add(new SetCardInfo("Sandblast", 24, Rarity.COMMON, mage.cards.s.Sandblast.class));
        cards.add(new SetCardInfo("Sandsteppe Mastodon", 137, Rarity.RARE, mage.cards.s.SandsteppeMastodon.class));
        cards.add(new SetCardInfo("Sandsteppe Outcast", 25, Rarity.COMMON, mage.cards.s.SandsteppeOutcast.class));
        cards.add(new SetCardInfo("Scoured Barrens", 171, Rarity.COMMON, mage.cards.s.ScouredBarrens.class));
        cards.add(new SetCardInfo("Scroll of the Masters", 163, Rarity.RARE, mage.cards.s.ScrollOfTheMasters.class));
        cards.add(new SetCardInfo("Shamanic Revelation", 138, Rarity.RARE, mage.cards.s.ShamanicRevelation.class));
        cards.add(new SetCardInfo("Shaman of the Great Hunt", 113, Rarity.MYTHIC, mage.cards.s.ShamanOfTheGreatHunt.class));
        cards.add(new SetCardInfo("Shifting Loyalties", 51, Rarity.UNCOMMON, mage.cards.s.ShiftingLoyalties.class));
        cards.add(new SetCardInfo("Shockmaw Dragon", 114, Rarity.UNCOMMON, mage.cards.s.ShockmawDragon.class));
        cards.add(new SetCardInfo("Shu Yun, the Silent Tempest", 52, Rarity.RARE, mage.cards.s.ShuYunTheSilentTempest.class));
        cards.add(new SetCardInfo("Sibsig Host", 82, Rarity.COMMON, mage.cards.s.SibsigHost.class));
        cards.add(new SetCardInfo("Sibsig Muckdraggers", 83, Rarity.UNCOMMON, mage.cards.s.SibsigMuckdraggers.class));
        cards.add(new SetCardInfo("Silumgar, the Drifting Death", 157, Rarity.RARE, mage.cards.s.SilumgarTheDriftingDeath.class));
        cards.add(new SetCardInfo("Smoldering Efreet", 115, Rarity.COMMON, mage.cards.s.SmolderingEfreet.class));
        cards.add(new SetCardInfo("Soulfire Grand Master", 27, Rarity.MYTHIC, mage.cards.s.SoulfireGrandMaster.class));
        cards.add(new SetCardInfo("Soulflayer", 84, Rarity.RARE, mage.cards.s.Soulflayer.class));
        cards.add(new SetCardInfo("Soul Summons", 26, Rarity.COMMON, mage.cards.s.SoulSummons.class));
        cards.add(new SetCardInfo("Sudden Reclamation", 139, Rarity.UNCOMMON, mage.cards.s.SuddenReclamation.class));
        cards.add(new SetCardInfo("Sultai Emissary", 85, Rarity.COMMON, mage.cards.s.SultaiEmissary.class));
        cards.add(new SetCardInfo("Sultai Runemark", 86, Rarity.COMMON, mage.cards.s.SultaiRunemark.class));
        cards.add(new SetCardInfo("Sultai Skullkeeper", 53, Rarity.COMMON, mage.cards.s.SultaiSkullkeeper.class));
        cards.add(new SetCardInfo("Supplant Form", 54, Rarity.RARE, mage.cards.s.SupplantForm.class));
        cards.add(new SetCardInfo("Swamp", 180, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swamp", 181, Rarity.LAND, mage.cards.basiclands.Swamp.class, new CardGraphicInfo(null, true)));
        cards.add(new SetCardInfo("Swiftwater Cliffs", 172, Rarity.COMMON, mage.cards.s.SwiftwaterCliffs.class));
        cards.add(new SetCardInfo("Tasigur's Cruelty", 88, Rarity.COMMON, mage.cards.t.TasigursCruelty.class));
        cards.add(new SetCardInfo("Tasigur, the Golden Fang", 87, Rarity.RARE, mage.cards.t.TasigurTheGoldenFang.class));
        cards.add(new SetCardInfo("Temporal Trespass", 55, Rarity.MYTHIC, mage.cards.t.TemporalTrespass.class));
        cards.add(new SetCardInfo("Temur Battle Rage", 116, Rarity.COMMON, mage.cards.t.TemurBattleRage.class));
        cards.add(new SetCardInfo("Temur Runemark", 140, Rarity.COMMON, mage.cards.t.TemurRunemark.class));
        cards.add(new SetCardInfo("Temur Sabertooth", 141, Rarity.UNCOMMON, mage.cards.t.TemurSabertooth.class));
        cards.add(new SetCardInfo("Temur War Shaman", 142, Rarity.RARE, mage.cards.t.TemurWarShaman.class));
        cards.add(new SetCardInfo("Thornwood Falls", 173, Rarity.COMMON, mage.cards.t.ThornwoodFalls.class));
        cards.add(new SetCardInfo("Torrent Elemental", 56, Rarity.MYTHIC, mage.cards.t.TorrentElemental.class));
        cards.add(new SetCardInfo("Tranquil Cove", 174, Rarity.COMMON, mage.cards.t.TranquilCove.class));
        cards.add(new SetCardInfo("Typhoid Rats", 89, Rarity.COMMON, mage.cards.t.TyphoidRats.class));
        cards.add(new SetCardInfo("Ugin's Construct", 164, Rarity.UNCOMMON, mage.cards.u.UginsConstruct.class));
        cards.add(new SetCardInfo("Ugin, the Spirit Dragon", 1, Rarity.MYTHIC, mage.cards.u.UginTheSpiritDragon.class));
        cards.add(new SetCardInfo("Valorous Stance", 28, Rarity.UNCOMMON, mage.cards.v.ValorousStance.class));
        cards.add(new SetCardInfo("Vaultbreaker", 117, Rarity.UNCOMMON, mage.cards.v.Vaultbreaker.class));
        cards.add(new SetCardInfo("Wandering Champion", 29, Rarity.UNCOMMON, mage.cards.w.WanderingChampion.class));
        cards.add(new SetCardInfo("Warden of the First Tree", 143, Rarity.MYTHIC, mage.cards.w.WardenOfTheFirstTree.class));
        cards.add(new SetCardInfo("Wardscale Dragon", 30, Rarity.UNCOMMON, mage.cards.w.WardscaleDragon.class));
        cards.add(new SetCardInfo("War Flare", 158, Rarity.COMMON, mage.cards.w.WarFlare.class));
        cards.add(new SetCardInfo("Whisk Away", 57, Rarity.COMMON, mage.cards.w.WhiskAway.class));
        cards.add(new SetCardInfo("Whisperer of the Wilds", 144, Rarity.COMMON, mage.cards.w.WhispererOfTheWilds.class));
        cards.add(new SetCardInfo("Whisperwood Elemental", 145, Rarity.MYTHIC, mage.cards.w.WhisperwoodElemental.class));
        cards.add(new SetCardInfo("Wildcall", 146, Rarity.RARE, mage.cards.w.Wildcall.class));
        cards.add(new SetCardInfo("Wild Slash", 118, Rarity.UNCOMMON, mage.cards.w.WildSlash.class));
        cards.add(new SetCardInfo("Will of the Naga", 58, Rarity.COMMON, mage.cards.w.WillOfTheNaga.class));
        cards.add(new SetCardInfo("Wind-Scarred Crag", 175, Rarity.COMMON, mage.cards.w.WindScarredCrag.class));
        cards.add(new SetCardInfo("Winds of Qal Sisma", 147, Rarity.UNCOMMON, mage.cards.w.WindsOfQalSisma.class));
        cards.add(new SetCardInfo("Write into Being", 59, Rarity.COMMON, mage.cards.w.WriteIntoBeing.class));
        cards.add(new SetCardInfo("Yasova Dragonclaw", 148, Rarity.RARE, mage.cards.y.YasovaDragonclaw.class));
    }

    @Override
    public List<CardInfo> getCardsByRarity(Rarity rarity) {
        // Common cards retrievement of Fate Reforged boosters - prevent the retrievement of the common lands (e.g. Blossoming Sands)
        if (rarity.equals(Rarity.COMMON)) {
            List<CardInfo> savedCardsInfos = savedCards.get(rarity);
            if (savedCardsInfos == null) {
                CardCriteria criteria = new CardCriteria();
                criteria.rarities(Rarity.COMMON);
                criteria.setCodes(this.code).notTypes(CardType.LAND);
                if (maxCardNumberInBooster != Integer.MAX_VALUE) {
                    criteria.maxCardNumber(maxCardNumberInBooster);
                }
                savedCardsInfos = CardRepository.instance.findCards(criteria);
                savedCards.put(rarity, savedCardsInfos);
            }
            // Return a copy of the saved cards information, as not to let modify the original.
            return new ArrayList<>(savedCardsInfos);
        } else {
            return super.getCardsByRarity(rarity);
        }
    }

    @Override
    public List<CardInfo> getSpecialCommon() {
        List<CardInfo> specialCommons = new ArrayList<>();
        if (savedSpecialCommon.isEmpty()) {
            // the 10 common lands from Fate Reforged can show up in the basic lands slot
            // http://magic.wizards.com/en/articles/archive/feature/fetching-look-fate-reforged-2014-12-24
            CardCriteria criteria = new CardCriteria();
            criteria.rarities(Rarity.COMMON).setCodes(this.code).types(CardType.LAND);
            savedSpecialCommon = CardRepository.instance.findCards(criteria);
            criteria.rarities(Rarity.LAND).setCodes(this.code);
            savedSpecialCommon.addAll(CardRepository.instance.findCards(criteria));
        }
        specialCommons.addAll(savedSpecialCommon);
        return specialCommons;
    }

    @Override
    public List<CardInfo> getSpecialRare() {
        List<CardInfo> specialRares = new ArrayList<>();
        if (savedSpecialRares.isEmpty()) {
            CardCriteria criteria = new CardCriteria();
            criteria.setCodes("KTK").name("Bloodstained Mire");
            savedSpecialRares.addAll(CardRepository.instance.findCards(criteria));
            criteria = new CardCriteria();
            criteria.setCodes("KTK").name("Flooded Strand");
            savedSpecialRares.addAll(CardRepository.instance.findCards(criteria));
            criteria = new CardCriteria();
            criteria.setCodes("KTK").name("Polluted Delta");
            savedSpecialRares.addAll(CardRepository.instance.findCards(criteria));
            criteria = new CardCriteria();
            criteria.setCodes("KTK").name("Windswept Heath");
            savedSpecialRares.addAll(CardRepository.instance.findCards(criteria));
            criteria = new CardCriteria();
            criteria.setCodes("KTK").name("Wooded Foothills");
            savedSpecialRares.addAll(CardRepository.instance.findCards(criteria));
        }
        specialRares.addAll(savedSpecialRares);
        return specialRares;
    }
}
