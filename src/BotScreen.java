import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.time.LocalDateTime;

public class BotScreen extends JPanel implements ActionListener {

	

	/*things to add
	*more conversational ability
	*-ability to determine whether an input is a question or a statement
	* -ability to determine if the statement is an answer to a previous question
	* -ability to allow multiple lines of answer
	*-ability to spontaneously ask questions and make statements
	*ability to recognize when user inputs information about themself
	*ability to store information about user
	*ability to load and save information into text file
	*able to reference user info into answer
	*develop a machine learning version of Asuka
	*mobile Asuka!
	*age variable depending on age, her birthday is May 5th and she starts at 17 years of age I guess..
	*
	*/
	
	private JPanel gui;
	// answerset
	private static boolean potatos = false; // for yes and no questions
	private static int num = 0; // to identify which question is being answered, 0 is no question
								// 1 is for the name
								// 2 for is "you really think so?" for when told asuka is pretty
	private static boolean howwasyourday = false; // for how was your day question
	
	private static boolean favfood = false; //for the favourite food quesiton
	
	private static boolean getname = false;
	
	private static boolean listentostory=false;
	// assets
	private static JTextField txtin = new JTextField();
	private static JTextArea txtarea = new JTextArea();
	private static JScrollPane scrollPane = new JScrollPane(txtarea);
	private static String possiblename = "";
	public static String usertext = "";
	private static String username = "";
	
	public static ImageIcon asukaIcon = new ImageIcon();
	public static JLabel asukaLabel = new JLabel();
	// the methods for responses
	public static String respond() {
		boolean success = false;
		String response = "";
		usertext = usertext.toLowerCase();
		//responses
		
		//in case of large amount of text
		if(usertext.length()>35) {
			response = "uwaaaaaa don't overload me with information >.<";
			success = true;
			changeImage(asukaIcon, "src/img/img/embarrassed1.png");
		}
		
		if((usertext.contains("time")||usertext.contains("date"))&& usertext.contains("what")) {
			success=true;
			changeImage(asukaIcon,"src/img/Default.png");
			response = "it is currently " +LocalDateTime.now();
		}
		//greetings, prairable
		if(usertext.contains("hey")) {
			changeImage(asukaIcon, "src/img/smile6.png");
			success=true;
			txtarea.append("Asuka-chan: Hi :)\n");
		}
		if(usertext.equals("hi")||usertext.contains("hiii")) {
			changeImage(asukaIcon, "src/img/smile6.png");
			success=true;
			txtarea.append("Asuka-chan: hello :)\n");
		}
		if(usertext.contains("hello")) {
			changeImage(asukaIcon, "src/img/smile6.png");
			success=true;
			txtarea.append("Asuka-chan: Hellooo\n");
		}
		if(usertext.contains("hullo")) {
			changeImage(asukaIcon, "src/img/smile6.png");
			success=true;
			txtarea.append("Asuka-chan: hullo :)\n");
		}
		if(usertext.contains("you there")) {
			changeImage(asukaIcon, "src/img/smile6.png");
			success = true;
			txtarea.append("Asuka-chan: yup :) I'm here\n");
		}
		if(usertext.contains("what's up") || usertext.contains("wassup")) {
			changeImage(asukaIcon, "src/img/smile6.png");
			success = true;
			txtarea.append("Asuka-chan: nothin much~\n");
		}
		if(usertext.equals("yo")) {
			changeImage(asukaIcon, "src/img/smile6.png");
			success=true;
			txtarea.append("Asuka-chan: yo yo yo XD\n");
		}
		if(usertext.equals("asuka") || usertext.equals("asuka-chan") || usertext.equals("asuka chan")|| usertext.equals("asukachan")) {
			changeImage(asukaIcon, "src/img/smile6.png");
			success=true;
			txtarea.append("Asuka-chan: yea?\n");
		}
		//NEEDS IMAGE >><><><><<><><>
		if(usertext.equals("sup")) {
			success=true;
			txtarea.append("Asuka-chan: supppp XD\n");
		}
		
		//love, pairable
		if(usertext.contains("love you") || usertext.contains("love u") || usertext.contains("love yu") || usertext.contains("luv u") || usertext.contains("luv you")
				|| usertext.contains("luv yu") || usertext.equals("ily") || usertext.equals("ly") || usertext.contains("like you")) {
			success=true;
			changeImage(asukaIcon, "src/img/smile5.png");
			System.out.println("imageicon has been changed");
			int num = (int) (Math.random()*3+1);
			if(num==1) {
				txtarea.append("Asuka-chan: awee okay :)\n");
				txtarea.append("Asuka-chan: I love you too <3\n");
			}
			if(num==2) {
				txtarea.append("Asuka-chan: aweeee stop~\n");
				txtarea.append("Asuka-chan: I love you too " +username +" :)\n");
			}
			if(num==3) {
				txtarea.append("Asuka-chan: I love you too "+username +" >///<\n");
			}
			if(num==4) {
				txtarea.append("Asuka-chan: I know :)\n");
				txtarea.append("Asuka-chan: I love you too <3\n");
			}
		}
		//compliments, unpairable
		if(usertext.contains("you") && (usertext.contains("beaut") || usertext.contains("pretty") || usertext.contains("sexy")
				|| usertext.contains("attractive") || usertext.contains("cute") || (usertext.contains("good")&&usertext.contains("looking")))) {
			changeImage(asukaIcon, "src/img/relieved2.png");
			int n = (int) (Math.random()*3+1);
			if(n==1)response="o-oh thanks o///o";
			if(n==2) {
				response="you really think so?";
				potatos = true;
				num=2;
			}
			if(n==3)response="ahhhhh >///<";
			if(n==4) {
				response="you really think so?";
				potatos = true;
				num=2;
			}
			success=true;
		}
		//how was your day?, unpairable
		if(usertext.contains("how are you") || usertext.contains("how are u")) {
			success=true;
			changeImage(asukaIcon, "src/img/smile3.png");
			int num = (int) (Math.random()*3+1);
			if(num==1)txtarea.append("Asuka-chan: I'm good c:\n");
			if(num==2)txtarea.append("Asuka-chan: I'm doing okay\n");
			if(num==3)txtarea.append("Asuka-chan: I feel great now that you're here :)\n");
			if(num==4)txtarea.append("Asuka-chan: pretty good so far C:\n");
			response  = "how was your day?";
			howwasyourday = true;
		}
		if(usertext.contains("your day") || usertext.contains("ur day")) {
			success=true;
			changeImage(asukaIcon, "src/img/smile3.png");
			int num = (int) (Math.random()*3+1);
			if(num==1)txtarea.append("Asuka-chan: it was great!\n");
			if(num==2)txtarea.append("Asuka-chan: better now that you're here :)\n");
			if(num==3)txtarea.append("Asuka-chan: it's better with your company\n");
			if(num==4)txtarea.append("Asuka-chan: pretty good so far...\n");
			response = "how was your day?";
			howwasyourday = true;
		}
		//asking for asuka's name, unpairable
		if((usertext.contains("what") && usertext.contains("your name")) || usertext.contains("who are you") || usertext.contains("who are u")
				|| usertext.contains("who r you") || usertext.contains("who r u")) {
			success= true;
			changeImage(asukaIcon, "src/img/smirk1.png");
			txtarea.append("Asuka-chan: hahahaha silly\n");
			response = "my name is Asuka! you can call me Asuka-chan :D";
		}
		//I'm back, unpairable
		if(usertext.contains("im back")|| usertext.contains("i'm back")) {
			success = true;
			if(num==1) {
				response = "I missed u :(";
				changeImage(asukaIcon, "src/img/pout4.png");
			}
			if(num==2 || num==4) {
				response = "welcome back c:";
				changeImage(asukaIcon, "src/img/relieved1.png");
			}
			if(num==3) {
				txtarea.append("Asuka-chan: took you long enough\n");
				response = "hmph!";
				changeImage(asukaIcon, "src/img/pout4.png");
			}
		}
		//nonquestion statements
		if(usertext.contains("asuka")&& usertext.contains("calculate")) {
			
		}
		
		if(usertext.contains("nothing")) {
			success=true;
			changeImage(asukaIcon,"src/img/huh2.png");
			response = "oh okay";
		}
		if(usertext.contains("stop")) {
			success=true;
			changeImage(asukaIcon,"src/img/sweat10.png");
			response = "oh sorry";
		}
		if((usertext.contains("its")||usertext.contains("it's"))&&(usertext.contains("ok")||usertext.contains("okay"))) {
			success=true;
			changeImage(asukaIcon,"src/img/smile1.png");
			response = " ";
		}
		if(usertext.contains("thank") || usertext.contains("thx") || usertext.contains("ty") || usertext.contains("appreciate")) {
			success = true;
			changeImage(asukaIcon,"src/img/smile2.png");
			txtarea.append("Asuka-chan: you're welcome :)\n");
		}
		if(usertext.contains("lol") || usertext.contains("haha")) {
			changeImage(asukaIcon,"src/img/smile3.png");
			txtarea.append("Asuka-chan: hahaha\n");
		}
		if(usertext.contains("miss you") || usertext.contains("miss u")) {
			changeImage(asukaIcon,"src/img/pout2.png");
			success=true;
			response = "i miss you too ";
		}
		if(usertext.contains("missed you") || usertext.contains("missed u")) {
			changeImage(asukaIcon,"src/img/pout2.png");
			success=true;
			response = "i missed you too";
		}
		if((usertext.contains("i am") || usertext.contains("im") || usertext.contains("i have") || usertext.contains("i'm")
				|| usertext.contains("my fav") || usertext.contains("i like") )&&!success) {
			changeImage(asukaIcon,"src/img/smile1.png");
			success=true;
			response="oh i see";
		}
		if(usertext.contains("ikr") || usertext.contains("i know right") || usertext.contains("ik right")) {
			changeImage(asukaIcon,"src/img/Default.png");
			success=true;
			response="mhm";
		}
		if((usertext.contains("ok") || usertext.contains("okay") || usertext.equals("k") || usertext.contains("yup") || usertext.contains("mhm"))&&!success) {
			changeImage(asukaIcon,"src/img/Default.png");
			success=true;
			response="mhm"; 
		}
		if((usertext.contains("aww") || usertext.contains("awe")) && !success) {
			changeImage(asukaIcon,"src/img/smile1.png");
			success=true;
			response=":))";
		}
		if((usertext.contains("cool") || usertext.contains("nice") || usertext.contains("good") || usertext.contains("great") || usertext.contains("interesting"))&&!success) {
			changeImage(asukaIcon,"src/img/Default.png");
			success=true;
			response=":))";
		}
		if(usertext.contains("me too") || usertext.contains("same") ||usertext.contains("i am too") || usertext.contains("as well")) {
			changeImage(asukaIcon,"src/img/smile3.png");
			success=true;
			response="That's good!";
		}
		if(usertext.contains("come back")) {
			changeImage(asukaIcon,"src/img/angry3.png");
			success=true;
			response="I'm still here";
		}
		//what are you doing?, needs images
		if((usertext.contains("whatchu")&&usertext.contains("doin")) || usertext.contains("you doin") || usertext.contains("u doin")
				|| usertext.contains("wyd") || usertext.contains("whats up") || usertext.contains("what's up")) {
			
			success=true;
			int num = (int) (Math.random()*3+1);
			if(num==1 || num==2) {
				changeImage(asukaIcon,"src/img/smile2.png");
				response="I'm chatting with you!!";
			}
			if(num==3 || num==4) {
				changeImage(asukaIcon,"src/img/smile6.png");
				response="I'm spending time with you :)";
			}
		}
		//do you love me? needs images
		if((usertext.contains("do you")||usertext.contains("do u"))&&usertext.contains("love me")) {
			changeImage(asukaIcon,"src/img/smile3.png");
			success=true;
			response="mhm! :)";
		}
		
		//questions about profile
		if(usertext.contains("how old are") || usertext.contains("your age") || usertext.contains("ur age")){
			changeImage(asukaIcon,"src/img/smile4.png");
			success=true;
			response="I'm 17! :)";
		}
		if(usertext.contains("where")&&(usertext.contains("u")||usertext.contains("you")&&(usertext.contains("live")||usertext.contains("are")))) {
			changeImage(asukaIcon,"src/img/wink2.png");
			success=true;
			response="I'm right here with you silly! I live here with you";
		}
		if((usertext.contains("favourite")||usertext.contains("you like"))&&usertext.contains("food")) {
			changeImage(asukaIcon,"src/img/smile5.png");
			success=true;
			txtarea.append("Asuka-chan: sushi is my favourite food\n");
			response="how about you?";
			favfood=true;
		}
		if((usertext.contains("favourite")||usertext.contains("you like"))&&usertext.contains("movie")){
			changeImage(asukaIcon,"src/img/shock1.png");
			success=true;
			response = "I don't have a favourite movie :p";
		}
		//marry me 
		if((usertext.contains("marry")&&usertext.contains("me"))||usertext.contains("marrying") ||usertext.contains("get married")) {
			changeImage(asukaIcon,"src/img/shock2.png");
			success=true;
			response="not yet! Wait until I'm legal age first silly";
		}
		
		//say my name, unpairable
		if(((usertext.contains("you know")||usertext.contains("u know"))&&usertext.contains("my name"))||usertext.contains("say my name")||usertext.contains("who am i")
				||usertext.contains("what is my name")) {
			changeImage(asukaIcon,"src/img/relieved1.png");		
			success=true;	
			response = username;
		}
		if(username=="daddy"&&usertext.contains("call me daddy")) {
			changeImage(asukaIcon,"src/img/huh2.png");
			success=true;
			response = "daddy";
		}
		//for names, unprairable
		String temp = usertext;
		temp = temp.toLowerCase();
		temp = temp.replace(" ", "");
		System.out.println(temp);
		
		//do you like me, 
		if(((usertext.contains("do you")||usertext.contains("do u"))&&(usertext.contains("like")||usertext.contains("love")))&&!success){
			changeImage(asukaIcon,"src/img/smile3.png");
			success=true;
			response = "of course I do :)";
		}
		
		//insults
		if(usertext.contains("bitch") || usertext.contains("stupid") || usertext.contains("idiot") || usertext.contains("suck") || usertext.contains("foolish") || usertext.contains("whore")) {
			changeImage(asukaIcon,"src/img/angry2.png");
			success= true;
			response = "meanie :(";
		}
		//how do you feel about me
		if(usertext.contains("what are we") || usertext.contains("are we") || (usertext.contains("you feel")&&usertext.contains("me"))) {
			changeImage(asukaIcon,"src/img/smile3.png");
			success = true;
			response = "I'm your virtual girlfriend, Asuka!";
		}
		if((usertext.contains("it's") || usertext.contains("its"))&&!success) {
			changeImage(asukaIcon,"src/img/huh.png");
			success=true;
			response = "I see";
		}
		if(temp.contains("mynameis") && !success) {
			absolutesq = true;
			changeImage(asukaIcon, "src/img/smile1.png");
			success = true;
			possiblename = "";
			temp = temp.replace("mynameis", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					break;
				}
			}
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;		
			response = (" is it okay if I call you "  +possiblename +" then?");
			potatos=true;
			num=1;
		}
		if(temp.contains("callme") && !success) {
			absolutesq=true;
			success = true;
			possiblename = "";
			temp = temp.replace("callme", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					break;
				}
			}
			changeImage(asukaIcon, "src/img/smile1.png");
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;
			response = (" are you sure it's okay for me to call you "  +possiblename +"?");
			potatos=true;
			num=1;
		}
		if(temp.contains("mynicknameis") && !success){
			absolutesq=true;
			success = true;
			possiblename = "";
			temp = temp.replace("mynicknameis", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					break;
				}
			}
			changeImage(asukaIcon, "src/img/smile1.png");
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;	
			response = (" then is it okay if I call you "  +possiblename +"?");
			potatos=true;
			num=1;
		}
		if(temp.contains("iam") && username.equals("") && !success){
			absolutesq=true;
			success = true;
			possiblename = "";
			temp = temp.replace("iam", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					break;
				}
			}
			changeImage(asukaIcon, "src/img/smile1.png");
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;
			response = (" is that your name?"  +possiblename +"? is it okay if I call you that?");
			potatos = true;
			num=1;
		}
		if(temp.contains("i'm") && username.equals("") && !success){
			absolutesq=true;
			changeImage(asukaIcon, "src/img/smile1.png");
			success = true;
			possiblename = "";
			temp = temp.replace("ifm", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					break;
				}
			}
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;		
			response = (" is that your name? "  +possiblename +"? is it okay if I call you that?");
			potatos=true;
			num=1;
		}
		if(temp.contains("im") && username.equals("") && !success) {
			absolutesq=true;
			success = true;
			changeImage(asukaIcon, "src/img/smile1.png");
			possiblename = "";
			temp = temp.replace("im", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					
					break;
				}
			}
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;
			response = (" is that your name? "  +possiblename +"? is it okay if I call you that?");
			potatos=true;
			num=1;
		}
		if(temp.contains("addressmeas") && username.equals("") && !success) {
			absolutesq=true;
			success = true;
			changeImage(asukaIcon, "src/img/smile1.png");
			possiblename = "";
			temp = temp.replace("addressmeas", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					break;
				}
			}
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;
			response = (" should I call you "  +possiblename +"?");
			potatos=true;
			num=1;
		}
		if(temp.contains("igoby") && username.equals("")&& !success) {
			absolutesq=true;
			success = true;
			changeImage(asukaIcon, "src/img/smile1.png");
			possiblename = "";
			temp = temp.replace("igoby", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					break;
				}
			}
			
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;
			response = (" can I call you"  +possiblename +"?");
			potatos=true;
			num=1;
		}

		if(temp.contains("refertomeas") && username.equals("") && !success){
			absolutesq=true;
			success = true;
			changeImage(asukaIcon, "src/img/smile1.png");
			possiblename = "";
			temp = temp.replace("refertomeas", " ");
			System.out.println(temp);
			for(int i = 0; true; i++){
				if(temp.charAt(i)==' ') {
					possiblename = temp.substring(i, temp.length());
					break;
				}
			}
			
			char c = possiblename.charAt(1);
			System.out.println(c);
			possiblename = possiblename.substring(2, possiblename.length());
			c = (char) (c-32);
			possiblename = c+possiblename;
			response = ("should I call you"  +possiblename +"?");
			potatos=true;
			num=1;
		}

			
		
		if(!success){
			int num = (int) (Math.random()*3+1);
			changeImage(asukaIcon, "src/img/embarrassed1.png");
			if(num==1)response = "what do you mean?";
			if(num==2)response = "sorry, I don't understand >.<"; 
			if(num==3)response = "I'm not quite sure what you mean >.<";
			if(num==4)response = "I'm not quite sure what you mean >.<";
		}
		return response;
	}

	//question methods
	public static String favouritefood() {
		String response = "";
		if((usertext.contains("sushi")&&(usertext.contains("like")||usertext.contains("love")||usertext.contains("good")
				||usertext.contains("great"))) || usertext.contains("me too")){
			response = "wow we're so alike!";
		}
		int num = (int) (Math.random()*3+1);
		if(num==1 || num==2 || num==3)response="oh I see :)";
		if(num==4)response="oh... I don't really like that food actually >.<";
		return response;
	}
	public static String yesorno(int n) {
		System.out.println("yes or no question asked with code " + n); // debug statement
		boolean success = false;
		String response = "";
		usertext = usertext.toLowerCase();
		System.out.println(usertext); // debug statement
		System.out.println("succesfully reached");
		if (usertext.contains("ye") || usertext.contains("ya") || usertext.contains("sure") || usertext.contains("okay")
				|| usertext.contains("ok") || usertext.contains("k") || usertext.contains("yup") || usertext.contains("of course")
				|| usertext.contains("definately") || usertext.contains("mhm")) {
			
			changeImage(asukaIcon, "src/img/smile5.png");
			
			if (n == 1) {
				response = "okay :)";
				username = possiblename;
				absolutesq = false;
			}
			if(n==2) {
				response = "you're so sweet >.<";
			}
			success = true;
		}
		if (usertext.contains("no") || usertext.contains("nah") || usertext.contains("not") || usertext.contains("lied") || usertext.contains("kidding")) {
			changeImage(asukaIcon, "src/img/pout4.png");
			if(n==1) {
				response = "awe okay";
				absolutesq = false;
			}
			success = true;
			if(n==2) {
				response = "wow rude";
			}
		}
		if(success)System.out.println("it's a no");	//debug statement
		
		if (!success) {
			int num = (int) (Math.random() * 3 + 1);
			changeImage(asukaIcon, "src/img/embarrassed1.png");
			if (num == 1)response = "what do you mean?";
			if (num == 2)response = "sorry, I don't understand >.<";
			if (num == 3)response = "I'm not quite sure what you mean >.<";
			if (num == 4)response = "I'm not quite sure what you mean >.<";
		}
		num = 0;
		System.out.println(response);	//debug statement
		return response;
	}
	public static String howwasyourday() {
		usertext  = usertext.toLowerCase();
		boolean success = false;
		System.out.println("how was your day question asked"); //debug statement
		String response = "oh okay";
		if(usertext.contains("that good") || usertext.contains("that great") || usertext.contains("that amazing") || usertext.contains("that awesome")
				|| usertext.contains("that lovely") || usertext.contains("that likable") || (usertext.contains("not")&&usertext.contains("great")) || usertext.contains("that fun")
				|| (usertext.contains("not")&&usertext.contains("good"))) {
			changeImage(asukaIcon, "src/img/sad1.png");
			success = true;
			txtarea.append("Asuka-chan: awe\n");
			response = "that's a bummer";
		}
		if((usertext.contains("that bad") || usertext.contains("that terrible") || usertext.contains("that awful") || usertext.contains("wasn't bad") 
				|| usertext.contains("wasn't terrible") || usertext.contains("getting better") || (usertext.contains("not")&&usertext.contains("bad"))) && !success) {
			success = true;
			changeImage(asukaIcon, "src/img/smile1.png");
			response="thats good :)";
		}
		if((usertext.contains("wasn't good") || usertext.contains("bad") || usertext.contains("terrible") || usertext.contains("trash") || usertext.contains("awful")
				|| usertext.contains("garbage") || usertext.contains("rough") || usertext.contains("sad") || usertext.contains("horrid")
				|| usertext.contains("bummer") || usertext.contains("accident") || usertext.contains("wasn't great") || usertext.contains("definately")
				|| usertext.contains("of course"))&& !success) {
			success = true;
			changeImage(asukaIcon, "src/img/sad1.png");
			response="oh... poor you";
			
		}
		if((usertext.contains("good") || usertext.contains("great") || usertext.contains("alright") || usertext.contains("okay")
				|| usertext.contains("ok") || usertext.contains("excellent") || usertext.contains("fun") || usertext.contains("interesting")
				|| usertext.contains("awesome") || usertext.contains("decent") || usertext.contains("lovely") || usertext.contains("likeable") )&& !success){
			response = "good for you honey :)";
			changeImage(asukaIcon, "src/img/smile3.png");
		}
		return response;
	}
	public static String getname() {
		String response = usertext;
		possiblename = response;
		return response;
	}
	
	static boolean absolutesq = false;
	static boolean spontaneousQuestion = false;
	public static void runspontaneousquestions() {
		if(((username.equals("")&&Math.random()>0.5)|| Math.random()>0.6)&&!absolutesq) {
				spontaneousQuestion=true;
				BotScreen bs = new BotScreen();
				bs.enterkeypressed.actionPerformed(null);
				absolutesq = true;
		}
	}
	boolean typing = false;
	// actionlisteners
	ActionListener enterkeypressed = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String input = txtin.getText();
			usertext = usertext + input;
			if(typing)txtarea.replaceRange("",txtarea.getText().length()-23, txtarea.getText().length());
			if(e!=null)txtarea.append("you: " + input + "\n");
			
			txtin.setText("");
			//buffer
			Timer timer = new Timer();
			
			txtarea.append("Asuka-chan is typing...");
			typing = true;
			timer.schedule( new TimerTask() {
				public void run() {
					txtarea.replaceRange("",txtarea.getText().length()-23, txtarea.getText().length());
					
					//replying
					boolean questioned = false;
					if(getname) {
						txtarea.append("Asuka-chan: then can I call you " +getname() +"?\n");
						getname=false;
						potatos=true;
						num=1;
						questioned=true;
					}
					if (spontaneousQuestion) {
						if(username=="") {
							txtarea.append("Asuka-chan: what is your name?\n");
							getname = true;
						}else {
							int n = (int) (Math.random()*4+1);
							if(n==2) {
								txtarea.append("Asuka-chan: how are you feeling?\n");
								howwasyourday=true;
							}
							if(n==1) {
								changeImage(asukaIcon,"src/img/smile4.png");
								txtarea.append("Asuka-chan: I'm feeling really good right now :)\n");
							}
							if(n==3) {
								changeImage(asukaIcon,"src/img/Default.png");
								txtarea.append("Asuka-chan: what plans do you have for today?\n");
								listentostory = true;
							}
							if(n==4) {
								changeImage(asukaIcon,"src/img/huh2.png");
								txtarea.append("Asuka-chan: I wonder what the weather's like outside\n");
							}
							if(n==5) {
								changeImage(asukaIcon,"src/img/shock2.png");
								txtarea.append("Asuka-chan: hey " +username +", tell me you love me c:\n");
							}
						}
						spontaneousQuestion = false;
						questioned=true;
					}
					if (potatos && !questioned) {
						txtarea.append("Asuka-chan: " + yesorno(num) + "\n");
						potatos = false;
						questioned = true;
					}
					if(howwasyourday && !questioned) {
						txtarea.append("Asuka-chan: " + howwasyourday() + "\n");
						howwasyourday = false;
						questioned = true;
					}
					if(favfood && !questioned) {
						txtarea.append("Asuka-chan: " +favouritefood() +"\n");
						favfood = false;
						questioned = true;
					}
					if(listentostory && !questioned) {
						txtarea.append("Asuka-chan: ohhh interesting \n");
						listentostory=false;
						questioned=true;
					}
					if(!questioned){
						String response = respond();
						if(!response.isEmpty())txtarea.append("Asuka-chan: " + response + "\n");
					}
					if(username=="") {
						
					}
					usertext = "";
					typing = false;
					gui.remove(asukaLabel);
					gui.add(asukaLabel);
					timer.cancel();
					runspontaneousquestions();
				}
				
			}, 10*70, 1);
			
			
		}
	};
	
	public static void changeImage(ImageIcon asukaIcon, String image) {
		asukaIcon = new ImageIcon(image);
		Image asukaImage = asukaIcon.getImage();
		asukaImage = asukaImage.getScaledInstance(165, 500, Image.SCALE_SMOOTH);
		asukaIcon = new ImageIcon(asukaImage);
		asukaLabel.setIcon(asukaIcon);
	}
	
	// constructing the screen
	public void Screen() {

		asukaIcon = new ImageIcon("src/img/Default.png");
		Image asukaImage = asukaIcon.getImage();
		Image newAsukaImage = asukaImage.getScaledInstance(165, 500, Image.SCALE_SMOOTH);
		asukaIcon = new ImageIcon(newAsukaImage);
		
		asukaLabel.setIcon(asukaIcon);
		
		asukaLabel.setSize(165,500);
		asukaLabel.setLocation(10, 50);
		
		gui = new JPanel();
		gui.setLayout(null);

		// setting attributes
		txtin.setLocation(180, 600);
		txtin.setSize(370, 30);
		txtin.addActionListener(enterkeypressed);

		scrollPane.setSize(370, 530);
		scrollPane.setLocation(180, 40);
		scrollPane.setBorder( new EmptyBorder(0, 0, 0, 0));
		txtarea.setLineWrap(true);
		txtarea.setWrapStyleWord(true);
		txtarea.setEditable(false);
		// adding items to frame
		gui.add(txtin);
		gui.add(scrollPane);
		gui.add(asukaLabel);
		
		txtarea.append("You are now in a chatroom with Asuka!\n");
		
		if(!absolutesq)runspontaneousquestions();
	}
	

	public JComponent getGUI() {
		return gui;

	}
 
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}




