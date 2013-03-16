package com.james.dotaprovider2;

import android.net.Uri;
import android.provider.BaseColumns;

public final class DotaHeroData {

	public static final String AUTHORITY = "com.james.provider.HeroInfo";
	
	private DotaHeroData(){}
	
	public static final class HeroInfo implements BaseColumns {
		private HeroInfo() {}
		
		public static final String TABLE_NAME = "hero_info";
		
		private static final String SCHEME = "content://";
		
		private static final String PATH_HERO_INFO = "/heroinfo";
		
		private static final String PATH_HERO_INFO_ID = "/heroinfo/";
		
		public static final Uri CONTENT_URI =  Uri.parse(SCHEME + AUTHORITY + PATH_HERO_INFO);
		
		public static final Uri CONTENT_ID_URI_BASE
        = Uri.parse(SCHEME + AUTHORITY + PATH_HERO_INFO_ID);
		
		public static final Uri CONTENT_ID_URI_PATTERN
        = Uri.parse(SCHEME + AUTHORITY + PATH_HERO_INFO_ID + "/#");
		
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.james.heroinfo";
		
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.james.heroinfo";
		
		public static final String DEFAULT_SORT_ORDER = "modified DESC";
		
		public static final String COLUMN_HERO_NAME_ZH = "hero_name_zh";
		
		public static final String COLUMN_HERO_NAME_EN = "hero_name_en";
		
		public static final String COLUMN_LOCATED_TAVERN = "located_tavern";
	}
}
