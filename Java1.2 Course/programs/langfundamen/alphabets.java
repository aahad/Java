// Print Alphabets using an array
class alphabets {
  public static void main(String args[]) {
	int j;
	char c[] = new char[26];
	char i = 'A';
	for (j=0; j<26; j++){
	c[j] = i;
	System.out.print(c[j]);
	i++;
	}
  }
}