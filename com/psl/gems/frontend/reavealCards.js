function revealCards(button) {
    var player = button.parentNode;
    var cards = player.querySelectorAll(".card-inner");
    cards.forEach(function(card) {
      card.classList.toggle("card-reveal");
      var cardId = card.id;
      var cardFront = card.querySelector(".card-front");
      var cardSrc = "background-image: url(image/" + cardId + ".png)";
      cardFront.setAttribute("style", cardSrc);
    });
}

function showWinner(playername,score){
    
    var player= document.getElementById("winner");
    var w=document.createElement('p');
    w.innerHTML='<h2>Congratulations !!<b>'+playername+'</b> is the winner of the game with score of '+score+'</h2>';
    player.appendChild(w);
   
  }

  function declareWinner(playername,score) {
    var code = Math.floor(Math.random() * 2);
    var winner = document.createElement('p');
    var section = document.getElementsByTagName('section')[0];
    if (code === 0) {
        winner.innerText = 'Congratulations !!'+playername+'is the winner of the game with score of '+score;
    } else {
        winner.innerText = 'Congratulations !!'+playername+'is the winner of the game with score of '+score;
    }
    section.appendChild(winner);
}