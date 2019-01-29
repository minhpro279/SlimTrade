package main.java.com.slimtrade.datatypes;

import java.util.ArrayList;

public enum CurrencyType {

	ALBINO_RHOA_FEATHER(""),
	ANCIENT_ORB(""),
	APPRENTICE_CARTOGRAPHERS_SEAL(""),
	APPRENTICE_CARTOGRAPHERS_SEXTANT(""),
	ARMOURERS_SCRAP(""),
	BESTIARY_ORB(""),
	BLACKSMITHS_WHETSTONE(""),
	BLESSED_ORB(""),
	BLESSING_OF_CHAYULA(""),
	BLESSING_OF_ESH(""),
	BLESSING_OF_TUL(""),
	BLESSING_OF_UUL_NETOL(""),
	BLESSING_OF_XOPH(""),
	CARTOGRAPHERS_CHISEL(""),
	CHAOS_ORB("chaos"),
	CHROMATIC_ORB(""),
	DIVINE_ORB(""),
	ENGINEERS_ORB(""),
	ETERNAL_ORB(""),
	EXALTED_ORB("ex"),
	GEMCUTTERS_PRISM(""),
	GLASSBLOWERS_BAUBLE(""),
	HARBINGERS_ORB(""),
	JEWELLERS_ORB(""),
	JOURNEYMAN_CARTOGRAPHERS_SEAL(""),
	JOURNEYMAN_CARTOGRAPHERS_SEXTANT(""),
	MASTER_CARTOGRAPHERS_SEAL(""),
	MASTER_CARTOGRAPHERS_SEXTANT(""),
	MIRROR_OF_KALANDRA(""),
	ORB_OF_ALCHEMY("alch"),
	ORB_OF_ALTERATION(""),
	ORB_OF_ANNULMENT(""),
	ORB_OF_AUGMENTATION(""),
	ORB_OF_BINDING(""),
	ORB_OF_CHANCE(""),
	ORB_OF_FUSING(""),
	ORB_OF_HORIZONS(""),
	ORB_OF_REGRET(""),
	ORB_OF_SCOURING(""),
	ORB_OF_TRANSMUTATION(""),
	PERANDUS_COIN(""),
	PORTAL_SCROLL(""),
	REGAL_ORB(""),
	SCROLL_FRAGMENT(""),
	SCROLL_OF_WISDOM(""),
	SILVER_COIN(""),
	STACKED_DECK(""),
	UNSHAPING_ORB(""),
	VAAL_ORB(""),
	;

	private ArrayList<String> tags = new ArrayList<String>();

	CurrencyType(String... tags) {
		for (String t : tags) {
			this.tags.add(t);
		}
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

}
