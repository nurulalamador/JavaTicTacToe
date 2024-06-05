import java.awt.*;

public class TicTacToe {
    Panel ticTacToe = new Panel();
    Button box[] = new Button[9];
    GridBagConstraints GBC = new GridBagConstraints();
    Button reset = new Button();
    Label currentPlayer = new Label();

    Panel players = new Panel();
    Label player1 = new Label("Player 1 (X)");
    Label player2 = new Label("Player 2 (O)");

    int myGridy = 0;

    Panel customPadding[] = new Panel[5];


    public TicTacToe() {
        for(int i=0; i<customPadding.length; i++) {
            customPadding[i] = new Panel();
        }

        ticTacToe.setLayout(new GridBagLayout());
        for(int i=0; i<9; i++) {
            box[i] = new Button();
            box[i].setPreferredSize(new Dimension(100,100));
            box[i].setFont(new Font("Sans", Font.PLAIN, 60));
            box[i].setBackground(new Color(240,240,240));
        }

        reset.setLabel("Reset Game");
        reset.setFont(new Font("Sans", Font.BOLD, 20));
        reset.setPreferredSize(new Dimension(200,60));
        reset.setBackground(new Color(60,60,60));
        reset.setForeground(Color.white);

        currentPlayer.setText("Player 1 (X) Move");
        currentPlayer.setPreferredSize(new Dimension(300, 50));
        currentPlayer.setBackground(new Color(120,120,120));
        currentPlayer.setAlignment(Label.CENTER);
        currentPlayer.setForeground(Color.white);
        currentPlayer.setFont(new Font("Sans", Font.BOLD, 18));

        player1.setBackground(new Color(90,90,90));
        player1.setForeground(Color.white);
        player1.setAlignment(Label.CENTER);
        player1.setFont(new Font("Arial", Font.BOLD, 18));
        player2.setBackground(new Color(220,220,220));
        player2.setForeground(Color.black);
        player2.setAlignment(Label.CENTER);
        player2.setFont(new Font("Arial", Font.BOLD, 18));



        players.setPreferredSize(new Dimension(300,55));
        players.setLayout(new GridLayout(1,2,10,10));
        players.add(player1);
        players.add(player2);


        GBC.gridx = 0;
        GBC.gridy = myGridy;
        GBC.gridwidth = 3;
        GBC.fill = GridBagConstraints.HORIZONTAL;
        ticTacToe.add(players,GBC);

        myGridy++;
        GBC.gridx = 0;
        GBC.gridy = myGridy;
        ticTacToe.add(customPadding[0],GBC);

        myGridy++;
        GBC.gridy = myGridy;
        ticTacToe.add(currentPlayer, GBC);

        myGridy++;
        GBC.gridx = 0;
        GBC.gridy = myGridy;
        ticTacToe.add(customPadding[1],GBC);

        myGridy++;
        GBC.gridx = 0;
        GBC.gridy = myGridy;
        GBC.gridwidth = 1;
        ticTacToe.add(box[0], GBC);

        GBC.gridx = 1;
        GBC.gridy = myGridy;
        ticTacToe.add(box[1], GBC);

        GBC.gridx = 2;
        GBC.gridy = myGridy;
        ticTacToe.add(box[2], GBC);


        myGridy++;

        GBC.gridx = 0;
        GBC.gridy = myGridy;
        ticTacToe.add(box[3], GBC);

        GBC.gridx = 1;
        GBC.gridy = myGridy;
        ticTacToe.add(box[4], GBC);

        GBC.gridx = 2;
        GBC.gridy = myGridy;
        ticTacToe.add(box[5], GBC);

        myGridy++;

        GBC.gridx = 0;
        GBC.gridy = myGridy;
        ticTacToe.add(box[6], GBC);

        GBC.gridx = 1;
        GBC.gridy = myGridy;
        ticTacToe.add(box[7], GBC);

        GBC.gridx = 2;
        GBC.gridy = myGridy;
        ticTacToe.add(box[8], GBC);

        myGridy++;
        GBC.gridx = 0;
        GBC.gridy = myGridy;
        ticTacToe.add(customPadding[2],GBC);

        myGridy++;
        GBC.gridx = 0;
        GBC.gridy = myGridy;
        GBC.gridwidth = 3;
        ticTacToe.add(reset, GBC);

        ticTacToe.setBackground(new Color(200,200,200));
    }

    public Panel getTicTacToe() {
        return ticTacToe;
    }


    public void setCurrentPlayer(String player) {
        if(player == "X") {
            player1.setBackground(new Color(90,90,90));
            player1.setForeground(Color.white);
            player2.setBackground(new Color(220,220,220));
            player2.setForeground(Color.black);
            currentPlayer.setText("Player 1 (X) Move");
        }
        else if(player == "O"){
            player2.setBackground(new Color(90,90,90));
            player2.setForeground(Color.white);
            player1.setBackground(new Color(220,220,220));
            player1.setForeground(Color.black);
            currentPlayer.setText("Player 2 (O) Move");
        }
        else if(player == "Draw") {
            player1.setBackground(new Color(220,220,220));
            player1.setForeground(Color.black);
            player2.setBackground(new Color(220,220,220));
            player2.setForeground(Color.black);
            currentPlayer.setText("Match Drawn!");
        }
        else {
            player1.setBackground(new Color(220,220,220));
            player1.setForeground(Color.black);
            player2.setBackground(new Color(220,220,220));
            player2.setForeground(Color.black);
            currentPlayer.setText(player);
        }
    }
}
