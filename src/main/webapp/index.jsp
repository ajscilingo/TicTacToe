<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
	
</script>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<form id="ticTacToeGameForm" action="ticTacToeGame" method="post">
		<input id="moveValue" type="hidden" name="move" value="">
		<table>
			<tr>
				<td><input id="btnUpperLeft" type="button" class="${board.upperLeftCell}" onclick="onClickUpperLeft()"></td>
				<td><input id="btnUpperMiddle" type="button" class="${board.upperMiddleCell}" onclick="onClickUpperMiddle()"></td>
				<td><input id="btnUpperRight" type="button" class="${board.upperRightCell}" onclick="onClickUpperRight()"></td>
			</tr>
			<tr>
				<td><input id="btnMiddleLeft" type="button" class="${board.middleLeftCell}" onclick="onClickMiddleLeft()"></td>
				<td><input id="btnMiddleMiddle" type="button" class="${board.middleMiddleCell}" onclick="onClickMiddleMiddle()"></td>
				<td><input id="btnMiddleRight" type="button" class="${board.middleRightCell}" onclick="onClickMiddleRight()"></td>
			</tr>
			<tr>
				<td><input id="btnLowerLeft" type="button" class="${board.lowerLeftCell}" onclick="onClickLowerLeft()"></td>
				<td><input id="btnLowerMiddle" type="button" class="${board.lowerMiddleCell}" onclick="onClickLowerMiddle()"></td>
				<td><input id="btnLowerRight" type="button" class="${board.lowerRightCell}" onclick="onClickLowerRight()"></td>
			</tr>
		</table>
	</form>
	<span>${game.gameState}</span>
</body>
</html>