package assignment;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Months {
	Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec;
}

enum Week {
	Sun, Mon, Tue, Wed, Thu, Fri, Sat;
}

public class Problem {

	/*
	 * Pattern p = Pattern.
	 * compile("^(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)? (\\d{4}|9{4}) ([DM]|X?) (Mon|Tue|Wed|Thu|Fri|Sat|Sun)?$"
	 * );
	 * 
	 * //Pattern p = Pattern.compile("^(?=.*(Jan) (\\d{4}|9{4}))(?=.*DOG).*$");
	 * Matcher m = p.matcher("Jan 0000 D Mon"); System.out.println(m.matches());
	 */
	private static int intWeek;
	private static String stringWeek;
	
	private static int intMonth;
	private static String stringMonth;

	private static int intYear;
	private static String stringYear;

	private static String inputDate;
	private static Boolean isLeapYear;
	
	private static final String pattern = "dd MMMM yyyy";
	private static final String pattern1 = "dd MM yyyy";

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the date - ");
		inputDate = scan.nextLine();
		scan.close();
		//inputDate = "Mar 2018 M";
		// Jan 2018 Tue, Case 1
		// Jan 2018 D, Case 0
		// Jan 2018 X, Tue, case 2
		// Jan 2018 M, Case 3

		int validDate = validateDate();

		switch (validDate) {

		case 0:
			multiplyDates();
			break;

		case 1:
			multiplyDatesofDay();
			break;

		case 2:
			multiplyDatesExcludeDay();
			break;

		case 3:
			multiplyFullDate();
			break;

		case 4:
			System.out.println("Invalid date format");
		}
	}

	public static int validateDate() {

		int inputStringLength = inputDate.length();
		if (inputStringLength > 14) {
			System.out.println("Input string longer than expected");
			return 4;
		} else {
			try {
				// split with single space as delimiter
				String[] inputArray = inputDate.split("\\s");
				// check if the month is correct
				if (contains(inputArray[0])) {
					intMonth = Months.valueOf(inputArray[0]).ordinal() + 1;
					stringMonth = inputArray[0];
					
					// check if the year is correct. Assuming the year is 0000
					// to 9999
					Pattern p = Pattern.compile("^(\\d{4})$");
					Matcher m = p.matcher(inputArray[1]);
					
					if (m.matches()) {
						stringYear = inputArray[1];
						intYear = Integer.valueOf(inputArray[1]);
						isLeapYear = isLeapYear(inputArray[1]);

						Pattern p1 = Pattern.compile("^[MDX]$");
						Matcher m1 = p1.matcher(inputArray[2]);
						
						if (m1.matches()) {

							if (inputArray[2].equals("D") && inputStringLength == 10) {
								return 0;
							} else if (inputArray[2].equals("M") && inputStringLength == 10) {
								return 3;
							} else if (inputArray[2].equals("X") && inputStringLength == 14) {
								if(containsWeek(inputArray[3]))
								{intWeek = Week.valueOf(inputArray[3]).ordinal() + 1;
								stringWeek = inputArray[3];
								return 2;
								}
								else{
									System.out.println("Invalid week after the char X in the input string");
									return 4;
								}
							} else{
								System.out.println("Invalid character after the year (or) invalid week after the char X in the input string");
								return 4;
							}
						} else if (containsWeek(inputArray[2]) && inputStringLength == 12) {
							intWeek = Week.valueOf(inputArray[2]).ordinal() + 1;
							stringWeek = inputArray[2];
							//System.out.println(stringWeek+"-"+intWeek);
							return 1;
						}

					} else {
						System.out.println("Invalid year in the input string");
						return 4;
					}
				} else {
					System.out.println("Invalid month in the input string");
					return 4;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return 4;
			}
		}
		return 4;
	}

	public static Boolean isLeapYear(String inputDate) {
		return Year.of(Integer.parseInt(inputDate)).isLeap();
	}

	public static void multiplyDates() {
		Month month = Month.of(intMonth);
		int days = month.length(isLeapYear);
		BigInteger output = new BigInteger("1");
		BigInteger multiplier = BigInteger.ONE;
		System.out.println("Total Number of days: " + days);
		for (int i = 1; i <= days; i++) {
			multiplier = BigInteger.valueOf(i);
			output = output.multiply(multiplier);
		}
		System.out.println("Product of all the dates in "+stringMonth+","+stringYear+" = "+ output);
	}

	public static void multiplyDatesofDay() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, intMonth-1);
		cal.set(Calendar.YEAR, intYear);
		
		Month month = Month.of(intMonth);
		int days = month.length(isLeapYear);
		int day,numDay=0;
		int totalDay = 1;
		
		Date date = null;
		String myDate = null;
		
		DateFormat format = new SimpleDateFormat(pattern);
		
		for(int i= 1;i<=days;i++)
		{
			// Adding day of month in Calendar.
			cal.set(Calendar.DAY_OF_MONTH, i);
			if (cal.get(Calendar.DAY_OF_WEEK) == intWeek)
			{
				date = cal.getTime();
				myDate = format.format(date);
				
				day=Integer.valueOf(myDate.substring(0, 2));
				System.out.println(day);
				totalDay=totalDay*day;
				numDay++;
			}
		}
		System.out.println("Number of "+stringWeek+" in "+stringMonth+","+stringYear+" = "+numDay);
		System.out.println("output - "+totalDay);

	}

	public static void multiplyDatesExcludeDay() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, intMonth-1);
		cal.set(Calendar.YEAR, intYear);
		
		Month month = Month.of(intMonth);
		int days = month.length(isLeapYear);
		int day,numDay=0;
		int totalDay = 1;
		Date date = null;
		String myDate = null;
		
		DateFormat format = new SimpleDateFormat(pattern);
		
		for(int i= 1;i<=days;i++)
		{
			// Adding day of month in Calendar.
			cal.set(Calendar.DAY_OF_MONTH, i);
			if (!(cal.get(Calendar.DAY_OF_WEEK) == intWeek))
			{
				date = cal.getTime();
				myDate = format.format(date);
				
				day=Integer.valueOf(myDate.substring(0, 2));
				System.out.println(day);
				totalDay=totalDay*day;
				numDay++;
			}
		}
		System.out.println("Number of days exluding "+stringWeek+" in "+stringMonth+","+stringYear+" = "+numDay);
		System.out.println("output - "+totalDay);
	}
	public static void multiplyFullDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, intMonth-1);
		cal.set(Calendar.YEAR, intYear);
		
		Month month = Month.of(intMonth);
		int days = month.length(isLeapYear);

		Date date = null;
		String myDate = null;
		
		BigInteger bigInt = BigInteger.ZERO;
		BigInteger totalBigInt = BigInteger.ONE;
		
		List <BigInteger> dateList = new ArrayList<BigInteger>();
		DateFormat format = new SimpleDateFormat(pattern1);
		
		for (int i = 1; i <= days; i++) {
			// Adding day of month in Calendar.
			cal.set(Calendar.DAY_OF_MONTH, i);

			date = cal.getTime();
			bigInt = BigInteger.valueOf(Long.parseLong(format.format(date).replaceAll("\\s", "")));
			totalBigInt = totalBigInt.multiply(bigInt);
			dateList.add(bigInt);
		}
		System.out.println(totalBigInt);
	}
	public static boolean contains(String test) {
		for (Months c : Months.values()) {
			if (c.name().equals(test)) {
				return true;
			}
		}
		return false;
	}
	public static boolean containsWeek(String test) {
		for (Week c : Week.values()) {
			if (c.name().equals(test)) {
				return true;
			}
		}
		return false;
	}
}
