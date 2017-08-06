<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Page Content -->
<div class="container">
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">마이페이지</h2>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form class="form-horizontal">
					<fieldset>
						<div class="col-lg-12">
							<img class="img-responsive"
								style="margin-left: auto; margin-right: auto; display: block;"
								width="100px" src="html/img/profile.png" alt=""> <br>
							<div class="col-md-12" align="center">
								<input id="filebutton" name="filebutton" class="input-file"
									type="file">
							</div>
							<br>
							<br>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">이름</label>
							<div class="col-md-7">
								<label class="control-label" for="textinput">홍길동</label>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">소속</label>
							<div class="col-md-7">
								<label class="control-label" for="textinput">캐드서브 스마트락팀</label>
							</div>
						</div>

						<!-- File Button -->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">아이디</label>
							<div class="col-md-7">
								<label class="control-label" for="textinput">gildonghong123</label>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">비밀번호</label>
							<div class="col-md-3">
								<input id="textinput" name="textinput" type="text"
									placeholder="현재 비밀번호" class="form-control input-md">
							</div>
							<div class="col-md-1">
								<button>변경</button>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">이메일</label>
							<div class="col-md-3">
								<label class="control-label" for="textinput">gildonghong123@cadserv.com</label>
							</div>
							<div class="col-md-1">
								<button>변경</button>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-5 control-label" for="textinput">전화번호</label>
							<div class="col-md-3">
								<label class="control-label" for="textinput">010-1234-5678</label>
							</div>
							<div class="col-md-1">
								<button>변경</button>
							</div>
						</div>
						<br>
						<!-- Button -->
						<div class="form-group" align="center">
							<button class="btn btn-default btn-md"
								style="height: 40px; width: 80px">submit</button>
						</div>

					</fieldset>
				</form>

			</div>
		</div>
	</div>
	<!-- /.row -->
	<hr>

	<!-- Footer -->
	<jsp:include page="../components/_footer_content.jsp" />

</div>

<jsp:include page="../components/_jslib.jsp" />
