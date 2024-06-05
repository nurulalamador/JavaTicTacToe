import java.awt.*;
import java.awt.event.*;

public class Main implements WindowListener, ActionListener {
    Frame mainFrame = new Frame("Ador TitTacToe");
    TicTacToe ticTacToe = new TicTacToe();
    Panel ticTacToePanel = ticTacToe.getTicTacToe();
    String currentType = "X";
    Boolean isNotWin = true;


    Main() {
        for(int i=0; i<9; i++) {
            ticTacToe.box[i].addActionListener(this);
        }

        ticTacToe.reset.addActionListener(this);

        mainFrame.addWindowListener(this);
        mainFrame.setLayout(new GridLayout(1,1));
        mainFrame.setSize(500,700);
        mainFrame.add(ticTacToePanel);
        mainFrame.setVisible(true);
    }

    void setBoxText(Button box) {
        if(currentType == "X") {
            box.setLabel("X");
            currentType = "O";
            ticTacToe.setCurrentPlayer("O");
            if(checkWin()) {
                ticTacToe.setCurrentPlayer("Player 1 (X) Win!");
                ticTacToe.reset.setLabel("New Game");
                isNotWin = false;
            }
        }
        else {
            box.setLabel("O");
            currentType = "X";
            ticTacToe.setCurrentPlayer("X");
            if(checkWin()) {
                ticTacToe.setCurrentPlayer("Player 2 (O) Win!");
                ticTacToe.reset.setLabel("New Game");
                isNotWin = false;
            }
        }

    }

    boolean checkWin() {
        if(ticTacToe.box[0].getLabel() != "" && ticTacToe.box[0].getLabel() == ticTacToe.box[1].getLabel() && ticTacToe.box[1].getLabel() == ticTacToe.box[2].getLabel()) {
            ticTacToe.box[0].setBackground(Color.pink);
            ticTacToe.box[1].setBackground(Color.pink);
            ticTacToe.box[2].setBackground(Color.pink);
            return true;
        }
        else if(ticTacToe.box[3].getLabel() != "" && ticTacToe.box[3].getLabel() == ticTacToe.box[4].getLabel() && ticTacToe.box[4].getLabel() == ticTacToe.box[5].getLabel()) {
            ticTacToe.box[3].setBackground(Color.pink);
            ticTacToe.box[4].setBackground(Color.pink);
            ticTacToe.box[5].setBackground(Color.pink);
            return true;
        }
        else if(ticTacToe.box[6].getLabel() != "" && ticTacToe.box[6].getLabel() == ticTacToe.box[7].getLabel() && ticTacToe.box[7].getLabel() == ticTacToe.box[8].getLabel()) {
            ticTacToe.box[6].setBackground(Color.pink);
            ticTacToe.box[7].setBackground(Color.pink);
            ticTacToe.box[8].setBackground(Color.pink);
            return true;
        }

        else if(ticTacToe.box[0].getLabel() != "" && ticTacToe.box[0].getLabel() == ticTacToe.box[3].getLabel() && ticTacToe.box[3].getLabel() == ticTacToe.box[6].getLabel()) {
            ticTacToe.box[0].setBackground(Color.pink);
            ticTacToe.box[3].setBackground(Color.pink);
            ticTacToe.box[6].setBackground(Color.pink);
            return true;
        }
        else if(ticTacToe.box[1].getLabel() != "" && ticTacToe.box[1].getLabel() == ticTacToe.box[4].getLabel() && ticTacToe.box[4].getLabel() == ticTacToe.box[7].getLabel()) {
            ticTacToe.box[1].setBackground(Color.pink);
            ticTacToe.box[4].setBackground(Color.pink);
            ticTacToe.box[7].setBackground(Color.pink);
            return true;
        }
        else if(ticTacToe.box[2].getLabel() != "" && ticTacToe.box[2].getLabel() == ticTacToe.box[5].getLabel() && ticTacToe.box[5].getLabel() == ticTacToe.box[8].getLabel()) {
            ticTacToe.box[2].setBackground(Color.pink);
            ticTacToe.box[5].setBackground(Color.pink);
            ticTacToe.box[8].setBackground(Color.pink);
            return true;
        }
        else if(ticTacToe.box[0].getLabel() != "" && ticTacToe.box[0].getLabel() == ticTacToe.box[4].getLabel() && ticTacToe.box[4].getLabel() == ticTacToe.box[8].getLabel()) {
            ticTacToe.box[0].setBackground(Color.pink);
            ticTacToe.box[4].setBackground(Color.pink);
            ticTacToe.box[8].setBackground(Color.pink);
            return true;
        }
        else if(ticTacToe.box[2].getLabel() != "" && ticTacToe.box[2].getLabel() == ticTacToe.box[4].getLabel() && ticTacToe.box[4].getLabel() == ticTacToe.box[6].getLabel()) {
            ticTacToe.box[2].setBackground(Color.pink);
            ticTacToe.box[4].setBackground(Color.pink);
            ticTacToe.box[6].setBackground(Color.pink);
            return true;
        }
        else {
            return false;
        }
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ticTacToe.reset) {
            currentType = "X";
            ticTacToe.setCurrentPlayer("X");
            ticTacToe.reset.setLabel("Reset Game");
            for(Button box: ticTacToe.box) {
                box.setBackground(new Color(240,240,240));
                box.setLabel("");
            }
            isNotWin = true;
        }
        else if(isNotWin) {
            Boolean draw = true;
            for(Button box: ticTacToe.box) {
                if(box == e.getSource() && box.getLabel() == "") {
                    setBoxText(box);
                }
                if(box.getLabel() == "") {
                    draw = false;
                }
            }
            if(draw && isNotWin == true) {
                ticTacToe.setCurrentPlayer("Draw");
                ticTacToe.reset.setLabel("New Game");
                isNotWin = false;
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}