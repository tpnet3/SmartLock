<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="private/_header.jsp">
	<jsp:param name="_nav" value="" />
</jsp:include>

<!-- Page Content -->
<div class="container">
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">일반사용자 회원가입</h2>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form class="form-horizontal">
					<fieldset>
						<br>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">아이디</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="아이디를 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">비밀번호</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="비밀번호를 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">비밀번호
								확인</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="비밀번호를 재입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">이름</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="이름을 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">이메일</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="이메일을 입력하세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">전화번호</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="전화번호를 입력해주세요." class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">

							<label class="col-md-5 control-label" for="textinput">기업명</label>
							<div class="col-md-3">
								<form class="form-search">
									<div class="input-append">
										<input type="text" class="span3" placeholder="기업명을 입력해주세요.">
										<button type="submit" class="btn">Search</button>
									</div>
								</form>

							</div>
						</div>
						<br>
						<!-- Button -->
						<div class="form-group" align="center">
							<button class="btn btn-default btn-md"
								style="height: 40px; width: 80px"
								onclick="location.href='sign_up_finish.jsp'">submit</button>
						</div>

					</fieldset>
				</form>

			</div>
		</div>
	</div>
	<!-- /.row -->
	<hr>

	<!-- Footer -->
	<jsp:include page="private/_footer_content.jsp" />

</div>
<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<jsp:include page="private/_footer.jsp" />
