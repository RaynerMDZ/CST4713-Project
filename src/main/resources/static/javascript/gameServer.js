(function (){

    function isWinner(moves, highlightWinner) {

        const url = "/api/v1/tic-tac-toe/" + moves.join("").replaceAll("?", "N");

        $.getJSON(url, function(winner) {
            console.log(winner);
            highlightWinner(winner);
        });

        console.log({url, moves, date: new Date()});
    }

    // creating a namespace in javascript
    window.cst4713 = window.cst4713 || {};
    window.cst4713.isWinnerServer = isWinner;
}) ();