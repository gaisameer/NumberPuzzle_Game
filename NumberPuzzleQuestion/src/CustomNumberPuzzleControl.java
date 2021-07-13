import java.awt.*;
import java.util.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		Button emptyButton = new Button();
		int count = 0;
		for(Button i : buttons) {
			if(i == buttonClicked) {
				break;
			}
			count++;
		}
		if(count + 1 == emptyCellId && (count+1)%4 !=0 ||
				count -1 == emptyCellId && (count-1)%4 !=3 ||
				count + 4 == emptyCellId ||
				count - 4 == emptyCellId) {
			
			swapButton(buttons[emptyCellId], buttonClicked);
			emptyCellId = count;
		}
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		Vector<Integer> v = new Vector<Integer>(15);
		for (int i = 1; i <= 15; i++)
            v.add(i);
		int pos = 0;
		while(v.size() > 0) {
			int a = (int)(getRandomNumber() * v.size() * 0.01);
			int val = v.get(a);
			arr[pos++] = val;
			
			int index = v.indexOf(val);
			v.remove(index);	
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int arr[] = getIntegerArrayOfButtonIds(buttons);
		for(int i=1; i<= 15; i++)
			if (arr[i] == i)
				return false;
			

		return winner;
	}
}