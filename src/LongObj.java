class LongObj {

	private int m_length;

	LongObj(int length) {

		m_length = length;

	}

}

class LongAndWideObj extends LongObj {

	LongAndWideObj(int length, int width) {
		super(length);
		m_width = width;

	}

	private int m_width;

}