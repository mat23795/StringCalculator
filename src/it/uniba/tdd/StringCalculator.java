package it.uniba.tdd;

public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
		int result = -1;

		if (numbersStr == "") {
			result = 0;
		} else {
			if (numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/' && numbersStr.contains("[")) {
				int posFin = numbersStr.indexOf(']');
				//char delimiter = numbersStr.charAt(2);
				String strDelim = "";
				strDelim += numbersStr.substring(3, posFin);
				String[] strArrayInput = numbersStr.substring(posFin+2).split(strDelim);

				int sum = 0;
				for (int i = 0; i < strArrayInput.length; i++) {
					if (Integer.valueOf(strArrayInput[i]) < 0) {
						throw new StringCalculatorException();
					}
					sum += Integer.valueOf(strArrayInput[i]);
					if (Integer.valueOf(strArrayInput[i]) >= 1000) {
						sum -= Integer.valueOf(strArrayInput[i]);
					}

				}
				result = sum;
			} else {
				if (numbersStr.charAt(0) == '/' && numbersStr.charAt(1) == '/') {
					char delimiter = numbersStr.charAt(2);
					String strDelim = "";
					strDelim += delimiter;
					String[] strArrayInput = numbersStr.substring(4).split(strDelim);

					int sum = 0;
					for (int i = 0; i < strArrayInput.length; i++) {
						if (Integer.valueOf(strArrayInput[i]) < 0) {
							throw new StringCalculatorException();
						}
						sum += Integer.valueOf(strArrayInput[i]);
						if (Integer.valueOf(strArrayInput[i]) >= 1000) {
							sum -= Integer.valueOf(strArrayInput[i]);
						}

					}
					result = sum;

				} else {
					String[] strArrayInput = numbersStr.split(",|\\n");

					int sum = 0;
					for (int i = 0; i < strArrayInput.length; i++) {
						if (Integer.valueOf(strArrayInput[i]) < 0) {
							throw new StringCalculatorException();
						}
						sum += Integer.valueOf(strArrayInput[i]);
						if (Integer.valueOf(strArrayInput[i]) >= 1000) {
							sum -= Integer.valueOf(strArrayInput[i]);
						}

					}
					result = sum;
				}
			}
		}
		return result;
	}
}