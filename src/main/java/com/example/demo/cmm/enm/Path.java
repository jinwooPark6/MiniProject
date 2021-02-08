package com.example.demo.cmm.enm;

public enum Path {
	DEFAULT_POSTER;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case DEFAULT_POSTER:
			result = "http://artinsight.co.kr/data/tmp/1605/3b177ed4145fc7746074a0bbcea5b6e5_htRjOnHub19d76gNzaI76lrd.jpg";
			break;

		default:
			break;
		}
		return result;
	}
}
