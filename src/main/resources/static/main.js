var welcomeMsg = 'favPlayer App';
document.querySelector('h1').innerText = welcomeMsg;

fetch('/favPlayer').then(resp => resp.json()).then(artists => {
        document.querySelector('#favPlayer').innerHTML = listArtists(artists);
    }
);

function listPlayer(json) {
    return `${json.map(listArtist).join('\n')}`;
};

let listPlayer = function(player) {
    return '<p>' + Player.PlayerId + ": " + Player.Player_name + '</p>' + ": " + Player.Sport + '</p>' + ": " + Player.Number + '</p>';
};

function postPlayer() {
    let = player{
        "PlayerId": document.getElementById("PLayerId").value,
        "Player_Name": document.getElementById("Player_Name").value
        "Sport": document.getElementById("Sport").value
        "Number": document.getElementById("Number").value
    }
    console.log(Player);
    console.log(Player.PlayerId);
    console.log(Player.Player_Name);
    console.log(PLayer.Sport);
    console.log(Player.Number);
        fetch("/favPlayer", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(favPlayer)
    }).then((result) => {
        if (result.status != 200) {
            throw new Error("Bad Server Response");
        }
        console.log(result.text());
    }).catch((error) => { console.log(error); })
    fetch('/favPlayer').then(resp => resp.json()).then(favPlayer => {
            document.querySelector('#favPlayer').innerHTML = listPlayer(favPlayer);
        }
    );
}

let button = document.querySelector('button');
button.addEventListener('mouseenter', function() {
    button.textContent = "Go!";
})