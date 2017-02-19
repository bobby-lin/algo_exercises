/**
 * Created by Bobby on 19/2/2017.
 * This is a variant of nim game.
 * We want to check if the starting player will win or lose given each player will make the optimum move.
 * Conditions:
 * Player 1 and Player 2 will have different ages.
 * Older player will start first.
 * A player loses when he cannot make any move during his turn.
 * Maximum moves per turn = 2
 */

function ProcessGame(p1_age, p1_dis, p2_age, p2_dis) {
    var MAX_MOVE = 2;
    var starting_player = "";
    if(p1_age > p2_age) {
        starting_player = "Player 1";
    } else {
        starting_player = "Player 2";
    }
    console.log(starting_player + " starts first");

    var dist = difference(p1_dis,p2_dis);
    console.log("Distance between two players = " + dist + " moves");

    // Condition: Starting player will win if "p" is a floating number
    var p = (dist - 1) / (MAX_MOVE + 1);
    console.log("p = " + p);
    if(Number.isInteger(p)) {
        console.log(starting_player + " will LOSE!");
    }
    else {
        console.log(starting_player + " will WIN!");
    }

}

function difference(num1, num2) {
    return Math.abs(num1-num2);
}

ProcessGame(10, 1, 5, 5);
