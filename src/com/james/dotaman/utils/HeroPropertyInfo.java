package com.james.dotaman.utils;

public class HeroPropertyInfo {

	private String mHeroId;
	private String mHeroName_zh;
	private String mHeroNickName_zh;
	private String mHeroName_en;
	
	private int mDPSIndex;
	private int mPushIndex;
	private int mGankIndex;
	private int mAssistIndex;
	private int mTankIndex;
	
	private int[] mSkills;
	private int[] mHP;
	private int[] mMP;
	private int[] mAttact;
	private int[] mShiled;
	private int[] mStrength;
	//private int[]敏捷
	//private int[] 智力
	
	public int getSkill1Id() {
		return mSkills[0];
	}
	
	public int getSkill2Id() {
		return mSkills[1];
	}
	
	public int getSkill3Id() {
		return mSkills[0];
	}
	
	public int getSkill4Id() {
		return mSkills[0];
	}
}
