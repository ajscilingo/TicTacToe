<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TicTacToe v0.0.1</title>
<script type="text/javascript" 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	
	function onClickUpperLeft() {
		$('#moveValue').attr("value", "moveUpperLeft");
		$('#ticTacToeGameForm').submit();
	}

	function onClickUpperMiddle() {
		$('#moveValue').attr("value", "moveUpperMiddle");
		$('#ticTacToeGameForm').submit();
	}

	function onClickUpperRight() {
		$('#moveValue').attr("value", "moveUpperRight");
		$('#ticTacToeGameForm').submit();
	}

	function onClickMiddleLeft() {
		$('#moveValue').attr("value", "moveMiddleLeft");
		$('#ticTacToeGameForm').submit();
	}

	function onClickMiddleMiddle() {
		$('#moveValue').attr("value", "moveMiddleMiddle");
		$('#ticTacToeGameForm').submit();
	}

	function onClickMiddleRight() {
		$('#moveValue').attr("value", "moveMiddleRight");
		$('#ticTacToeGameForm').submit();
	}

	function onClickLowerLeft() {
		$('#moveValue').attr("value", "moveLowerLeft");
		$('#ticTacToeGameForm').submit();
	}

	function onClickLowerMiddle() {
		$('#moveValue').attr("value", "moveLowerMiddle");
		$('#ticTacToeGameForm').submit();
	}

	function onClickLowerRight() {
		$('#moveValue').attr("value", "moveLowerRight");
		$('#ticTacToeGameForm').submit();
	}
	
	function onClickPlayAgain(){
		$(location).attr('href', 'index.jsp');
	}
	
</script>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<form id="ticTacToeGameForm" action="ticTacToeGame" method="post">
		<input id="moveValue" type="hidden" name="move" value="">
	</form>
	<table>
		<tr>
			<td><button id="btnUpperLeft" class="${board.upperLeftCell}"
					onclick="onClickUpperLeft()">
					<div class="${board.upperLeftCell}">${board.upperLeftCell}</div>
					</button></td>
			<td><button id="btnUpperMiddle" class="${board.upperMiddleCell}"
					onclick="onClickUpperMiddle()">
					<div class="${board.upperMiddleCell}">${board.upperMiddleCell}</div>
					</button></td>
			<td><button id="btnUpperRight" type="button"
					class="${board.upperRightCell}" onclick="onClickUpperRight()">
					<div class="${board.upperRightCell}">${board.upperRightCell}</div>
					</button></td>
		</tr>
		<tr>
			<td><button id="btnMiddleLeft" class="${board.middleLeftCell}"
					onclick="onClickMiddleLeft()">
					<div class="${board.middleLeftCell}">${board.middleLeftCell}</div>
					</button></td>
			<td><button id="btnMiddleMiddle"
					class="${board.middleMiddleCell}" onclick="onClickMiddleMiddle()">
					<div class="${board.middleMiddleCell}">${board.middleMiddleCell}</div>
				</button></td>
			<td><button id="btnMiddleRight" class="${board.middleRightCell}"
					onclick="onClickMiddleRight()">
					<div class="${board.middleRightCell}">${board.middleRightCell}</div>
				</button></td>
		</tr>
		<tr>
			<td><button id="btnLowerLeft" class="${board.lowerLeftCell}"
					onclick="onClickLowerLeft()">
					<div class="${board.lowerLeftCell}">${board.lowerLeftCell}</div>
				</button></td>
			<td><button id="btnLowerMiddle" class="${board.lowerMiddleCell}"
					onclick="onClickLowerMiddle()">
					<div class="${board.lowerMiddleCell}">${board.lowerMiddleCell}</div>
				</button></td>
			<td><button id="btnLowerRight" class="${board.lowerRightCell}"
					onclick="onClickLowerRight()">
					<div class="${board.lowerRightCell}">${board.lowerRightCell}</div>
				</button></td>
		</tr>
	</table>
	<div id="playAgain" style="${playAgainVisibilityStyle}">
		<div id="playAgainInner">
			<div id="playAgainInnerText">
				${game.gameStateHTML}
			</div>
		<button id="btnPlayAgain" onclick="onClickPlayAgain()">Play Again</button>
		</div>
	</div>
	<div id="oneOrTwoPlayers" style="${numberOfPlayersVisibilityStyle}">
		<div id="oneOrTwoPlayersInner">
			<h1>Number Of Players?</h1>
			<form id="numberOfPlayersForm" action="ticTacToeGame" method="post">
				<input onchange='this.form.submit();' type="radio" name="humanPlayer" value="false">1 Player<br>
				<input onchange='this.form.submit();' type="radio" name="humanPlayer" value="true">2 Player<br>
			</form>
		</div>
	</div>
</body>
</html>