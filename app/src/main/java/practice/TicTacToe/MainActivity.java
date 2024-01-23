package practice.TicTacToe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    char[][] board = new char[3][3];
    boolean isXturn = true;
    TextView turnTextView;
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedButton  = (Button) v;
            clickedButton.setText(isXturn ? "X" : "O");
            clickedButton.setEnabled(false);
            updateBoardState(clickedButton.getId(), isXturn ? 'X' : 'O');
            if (checkForWinner(isXturn ? 'X' : 'O')) {
                turnTextView.setText(isXturn ? "X wins!" : "O wins!");
                disableAllButtons();
                return;
            }
            isXturn = !isXturn;
            updateTurnText();
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();
        turnTextView = findViewById(R.id.turnTextView);
    }
    private void disableAllButtons() {
        int[] buttonIds = {R.id.but1, R.id.but2, R.id.but3, R.id.but4, R.id.but5, R.id.but6, R.id.but7, R.id.but8, R.id.but9};
        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setEnabled(false);
        }
    }
    private void setupButtons() {
        int[] buttonIds = {R.id.but4, R.id.but2, R.id.but3, R.id.but1, R.id.but5, R.id.but6
        , R.id.but7, R.id.but8, R.id.but9};
        for (int id : buttonIds) {
            Button button  = findViewById(id);
            button.setOnClickListener(buttonClickListener);
        }
    }
    private void updateTurnText() {
        turnTextView.setText("It's " + (isXturn ? " X" : " O") + " turn");
    }
    private void updateBoardState(int buttonId, char player) {
        if (buttonId == R.id.but1) {
            board[0][0] = player;
        } else if (buttonId == R.id.but2) {
            board[0][1] = player;
        } else if (buttonId == R.id.but3) {
            board[0][2] = player;
        } else if (buttonId == R.id.but4) {
            board[1][0] = player;
        } else if (buttonId == R.id.but5) {
            board[1][1] = player;
        } else if (buttonId == R.id.but6) {
            board[1][2] = player;
        } else if (buttonId == R.id.but7) {
            board[2][0] = player;
        } else if (buttonId == R.id.but8) {
            board[2][1] = player;
        } else if (buttonId == R.id.but9) {
            board[2][2] = player;
        }
    }
    private boolean checkForWinner(char player) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

}
