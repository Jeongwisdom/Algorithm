# [Silver II] 재채점을 기다리는 중 - 28286 

[문제 링크](https://www.acmicpc.net/problem/28286) 

### 성능 요약

메모리: 14528 KB, 시간: 104 ms

### 분류

백트래킹, 브루트포스 알고리즘, 구현

### 제출 일자

2025년 2월 9일 04:20:54

### 문제 설명

<p>UCPC고등학교에 다니는 민규는 최근에 기말고사를 치게 되었다. 기말고사는 $N$문제로 이루어져 있고, 각 문제는 보기가 1 이상 5 이하의 정수로 이루어진 객관식 문제이다.</p>

<p>시간이 지나 학교에서 성적표를 받은 민규는 집에서 매겨본 점수보다 훨씬 낮은 점수를 받고 깜짝 놀랐다. 알고 보니 민규는 OMR 카드에 답안을 밀려 썼던 것이다. 억울하지만 어쩔 수 없이 결과를 받아들여야 했던 민규는 자신이 답안을 제대로 썼다면 얼마나 잘 봤을지라도 알아보기로 했다.</p>

<p>민규는 OMR 카드에 쓴 답안을 밀거나 당기는 작업을 최대 $K$번 할 수 있다. 답안을 한 번 밀거나 당기려면 우선 기준점이 될 문제의 번호 $p$를 하나 잡고, 다음 중 하나를 시행한다.</p>

<ul>
	<li>당기기: $p$번 문제의 뒤 문제들에 쓴 답안을 모두 직전 문제로 옮기고, 마지막 문제는 답안을 쓰지 않은 것으로 취급한다.</li>
	<li>밀기: $p$번 및 그 뒤의 문제들에 쓴 답안을 모두 직후 문제로 옮기고, $p$번 문제는 답안을 쓰지 않은 것으로 취급한다. 마지막 문제에 쓴 답안은 버린다.</li>
</ul>

<p>다음은 3번 문제를 기준으로 답안을 밀거나 당기는 예시이다.</p>

<table align="center" border="1" cellpadding="1" cellspacing="1" class="table table-bordered" style="width: 500px;">
	<thead>
		<tr>
			<th scope="col" style="text-align: center;">문제번호</th>
			<th scope="col" style="text-align: center;">1</th>
			<th scope="col" style="text-align: center;">2</th>
			<th scope="col" style="text-align: center;">3</th>
			<th scope="col" style="text-align: center;">4</th>
			<th scope="col" style="text-align: center;">5</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align: center;">OMR카드 원본</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">2</td>
			<td style="text-align: center;">4</td>
			<td style="text-align: center;">5</td>
			<td style="text-align: center;">1</td>
		</tr>
		<tr>
			<td style="text-align: center;">당기기</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">2</td>
			<td style="text-align: center;">5</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">.</td>
		</tr>
		<tr>
			<td style="text-align: center;">밀기</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">2</td>
			<td style="text-align: center;">.</td>
			<td style="text-align: center;">4</td>
			<td style="text-align: center;">5</td>
		</tr>
	</tbody>
</table>

<p>기준점의 번호는 매 작업마다 달라도 된다.</p>

<p>답안을 밀거나 당기는 작업을 최대 $K$번 실행한 후 민규가 맞힐 수 있는 문제의 최대 개수를 구하시오. 작업을 $K$번보다 적게 하거나 아예 안 할 수도 있음에 유의하여라.</p>

### 입력 

 <p>첫 줄에 문제 수 $N$과 답안을 밀거나 당길 수 있는 최대 횟수 $K$가 주어진다. $(5 \le N \le 20$; $0 \le K \le 3)$</p>

<p>그 다음 줄에 각 문제의 정답을 나타내는 1 이상 5 이하의 정수가 차례대로 주어진다.</p>

<p>그 다음 줄에 민규가 OMR 카드에 기입한 답안을 나타내는 1 이상 5 이하의 정수가 차례대로 주어진다.</p>

### 출력 

 <p>민규가 맞힐 수 있는 문제의 최대 개수를 출력한다.</p>

