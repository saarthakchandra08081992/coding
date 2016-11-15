
public class versionNumbers {

	private static String[] makeEqual(String s1, String s2) {

		String larger = s1.length() > s2.length() ? s1 : s2;
		String smaller = s1.length() > s2.length() ? s2 : s1;
		int diff = larger.length() - smaller.length();
		while (diff-- > 0) {
			smaller += "0";
		}
		return new String[] { larger, smaller };

	}

	private static String versionNums(String ver1, String ver2) {
		ver1 = ver1.replaceAll("[^0-9]", "");
		ver2 = ver2.replaceAll("[^0-9]", "");

		if (ver1.length() == ver2.length())
			return (Integer.valueOf(ver1) > Integer.valueOf(ver2) ? ver1 : ver2);
		else {
			String[] newValues = makeEqual(ver1, ver2);
			return (Integer.valueOf(newValues[0]) > Integer.valueOf(newValues[1]) ? newValues[0] : newValues[1]);
		}
	}

	private static int norm(String str1,String str2){
		int s1 =Integer.valueOf(str1);
		int s2 =Integer.valueOf(str2);
		return (int) Math.sqrt(Math.pow(s1, 2) + Math.pow(s1, 2));
	}
	
	private static String checkVersions(String ver1, String ver2) {
		String[] s1 = ver1.split(".");
		String[] s2 = ver2.split(".");
		int smaller = s2.length < s1.length ? s2.length : s1.length;
		for (int i = 0; i < smaller; i++) {

			int larger = s1[i].length() > s2[i].length() ? s1[i].length() : s2[i].length();

			if (norm(s1[i],s2[i]) < norm(s2[i],s1[i]))
				return ver2;
			else if (Integer.valueOf(s1[i]) > Integer.valueOf(s2[i]))
				return ver1;
		}
		return ver1.length() > ver2.length() ? ver1 : ver2;
	}

	public static void main(String[] args) {
		System.out.println(versionNums("2.2", "2.164"));
		System.out.println(checkVersions("2.2", "2.164"));
	}
}
