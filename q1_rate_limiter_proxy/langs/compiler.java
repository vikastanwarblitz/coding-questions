//compiler boilderplate
class abc{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.next();
        scanner.close();

        Solution sol = new Solution();
        System.out.print(Character.toString(sol.firstChar(myString)));
    }
}
