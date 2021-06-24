"use strict";
(function () {
    let isX = true;
    let isWinner = false;

    const message = $("#message");

    const highlightWinner = function(winner) {

        if(winner.whoWon === "X" || winner.whoWon === "O") {

            const smallBox = $(".small-box");

            let div1 = smallBox[winner.p1]
            let div2 = smallBox[winner.p2]
            let div3 = smallBox[winner.p3]
            $(div1).addClass("winner");
            $(div2).addClass("winner");
            $(div3).addClass("winner");
            isWinner = true;
            message.text("winner was found at: " + winner.whoWon);

        }
    };

    $(".small-box").click(function () {
        message.text("");

        let value = $(this).text();
        if (value !== "?" || isWinner) {
            let lMessage = "invalid move, stop touching me cheater!!";
            message.text(lMessage);
            return;
        }

        let xOrO = isX ? "X" : "O";
        $(this).text(xOrO);
        isX = !isX;

        let moves = $(".small-box").text().split("");

        /* check to see if winner was found */
        let whichFunction = window.cst4713.isWinnerServer;
        let winner = whichFunction(moves, highlightWinner);

    });

    $("#btn-clear").click( () => {
        $(".small-box").text("?");
        $("#message").text("");
        isWinner = false;
        $(".small-box").removeClass("winner");
    })

})();