package com.slimtrade.core.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.slimtrade.core.References;

public class VersionNumber {

    //TODO : Add prerelease support?

	public final int major;
	public final int minor;
	public final int patch;
	public final boolean pre;
	
	private String matchString = "\"?(PRE-)?v?(\\d+)\\.(\\d+)\\.(\\d+)\"?";
	
	public VersionNumber(String string){
		Pattern pattern = Pattern.compile(matchString);
		Matcher matcher = pattern.matcher(string);
		if(!matcher.matches()){
			major = -1;
			minor = -1;
			patch = -1;
			pre = false;
		}else{
            if(matcher.group(1) != null) {
                pre = true;
            } else {
                pre = false;
            }
			major = Integer.parseInt(matcher.group(2));
			minor = Integer.parseInt(matcher.group(3));
			patch = Integer.parseInt(matcher.group(4));
		}
	}
	
	public String toString(){
		return major + "." + minor + "." + patch;
	}
	
	public static boolean isNewVersion(VersionNumber v1){
		return isNewVersion(new VersionNumber(References.APP_VERSION), v1);
	}
	
	public static boolean isNewVersion(VersionNumber v1, VersionNumber v2){
		if(v2.major>v1.major){
			return true;
		}
		if(v2.major>=v1.major && v2.minor>v1.minor){
			return true;
		}
		if(v2.major>=v1.major && v2.minor>=v1.minor && v2.patch > v1.patch){
			return true;
		}
		return false;
	}
}
