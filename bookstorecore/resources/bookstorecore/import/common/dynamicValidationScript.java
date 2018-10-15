 char[] digits = getISBN10().toCharArray();
 if (digits.length != 10) {
	 return false;
 }
        
int sum = 0;
for (int i = 1; i <= digits.length; i++) {
	sum += i * digits[i - 1];
}

if (sum % 11 == 0) {
	return true;
}
return false;