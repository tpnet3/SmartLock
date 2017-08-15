<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
	<jsp:param name="_title" value="License" />
	<jsp:param name="_nav" value="license" />
	<jsp:param name="_css" value="/html/css/mouse-over.css" />
</jsp:include>

<!-- Page Content -->
<div class="container">
	<!-- Service Panels -->
	<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">라이센스 요청현황</h2>
			<ol class="breadcrumb">
				<li><a href="/license/user">라이센스 발급현황</a>
				</li>
				<li class="active">라이센스 요청현황</li>
			</ol>
		</div>
		<!-- 검색필터-->
		 <div class="row">
		<div class="col-sm-12">
			<div class="col-sm-2">
				<div class="input-group">
					<select name="" id="location1"
					style="width: 180px; height: 35px;">
					<option value="">소프트웨어명</option>
					<option value="">Microsoft Excel</option>
					<option value="">Parallels Desktop</option>
					<option value="">Adobe CC</option>
					<option value="">Football Manager</option>
				</select>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="input-group">
					<select name="" id="location1"
					style="width: 180px; height: 35px;">
					<option value="">요청 날짜</option>
					<option value="">오름차순</option>
					<option value="">내림차순</option>
				</select>
				</div>
			</div>
			<div class="col-sm-6">
			<input type="text" class="col-md-4" placeholder="검색어를 입력하세요"
					id="searchField" style="width: 300px; height: 35px;">&nbsp;&nbsp;
					<button class="btn btn-primary" type="button" id="searchButton"
					data-loading-text="Searching..">
					<i class="fa fa-search"></i>
				</button>
				</div>
			</div>

		</div>
		<br>
		<!-- 검색필터-->
</div>
<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center">
				</h2>
			</div>
			<div id="no-more-tables">
				<table class="col-sm-12 table-bordered table-striped table-condensed cf">
					<thead class="cf" align="center">
						<tr>
							<td width="10px"><h4><b>No.</h4></td>
							<td width="250px"><h4><b>소프트웨어</h4></td>
							<td width="200px"><h4><b>회사명</h4></td>
							<td width="150px"><h4><b>요청일자</h4></td>
							<td width="100px"><h4><b>상태</h4></td>
						</tr>
					</thead>
					<tbody align="center">
						<tr data-repeat="list">
							<td data-bind="no" class="data-no">1</td>
							<td data-bind="소프트웨어">Microsoft Excel</td>
							<td data-bind="회사명">Microsoft</td>
							<td data-bind="요청일자">2016-11-31</td>
							<td data-bind="상태일반요청"><span class="label label-success">일반 요청</span></td>
							<td data-bind="상태데모요청"><span class="label label-success" onmouseout="this.style.background='#5cb85c';
							this.innerText='데모 요청';" onmouseover="this.style.background='#58ACFA';this.innerText='연장 요청';">데모 요청</span></td>

							<td data-bind="상태발급거절"><span class="label label-danger" onmouseout="this.style.background='#DF5A5A';this.innerText='발급 거절';" onmouseover="this.style.background='#58ACFA';this.innerText='발급 재요청';">발급거절</span></td>
						</tr>


				</tbody>
			</table>
		</div>
	</div>
</div>
</div>
<!-- /.container -->
	<!-- Pagination -->
	<div class="row text-center">
		<div class="col-lg-12">
			<ul class="pagination">
				<li>
					<a href="#">&laquo;</a>
				</li>
				<li class="active">
					<a href="#">1</a>
				</li>
				<li>
					<a href="#">2</a>
				</li>
				<li>
					<a href="#">3</a>
				</li>
				<li>
					<a href="#">4</a>
				</li>
				<li>
					<a href="#">5</a>
				</li>
				<li>
					<a href="#">&raquo;</a>
				</li>
			</ul>
		</div>
	</div>
	<!-- /.row -->
	<hr>

	<!-- Footer -->
	<jsp:include page="include/_footer_content.jsp" />

</div>

<jsp:include page="include/_jslib.jsp" />

<script src="/html/js/jquery-repeat.js"></script>
<script language="javaScript">

    /*
    데이터를 가져옵니다.

    query: {
        option1: "",
        option2: "",
        str: "",
        page: ""
    }
    */
    var requestData = function(query) {
        /*
        $.ajax({
            url : "/",
            type : "GET",
            dataType : "json",
            data : query,
            success : function (data){
                if(data.result == "success") {
                    repeatData(data['description']);
                } else {

                }
            },
            error : function(data, textStatus, errorThrown) {

            }
        });
        */

        var sample = [{
            no: "1",
            소프트웨어: "Microsoft Excel",
            회사명: "Microsoft",
            요청일자: "2016-11-31",
            상태: "데모요청"
        }, {
            no: "2",
            소프트웨어: "Microsoft Excel",
            회사명: "Microsoft",
            요청일자: "2016-11-31",
            상태: "일반요청"
        }, {
            no: "3",
            소프트웨어: "Microsoft Excel",
            회사명: "Microsoft",
            요청일자: "2016-11-31",
            상태: "발급거절"
        }, {
            no: "4",
            소프트웨어: "Parallels Desktop",
            회사명: "Microsoft",
            요청일자: "2017-03-21",
            상태: "데모요청"
        }, {
            no: "5",
            소프트웨어: "Parallels Desktop",
            회사명: "Microsoft",
            요청일자: "2017-03-21",
            상태: "데모요청"
        }, {
            no: "6",
            소프트웨어: "Parallels Desktop",
            회사명: "Microsoft",
            요청일자: "2017-03-21",
            상태: "발급거절"
        }];

        repeatData(sample);
    };

    /*
     리스트를 반복합니다.

     data: [{
         no: "1",
         소프트웨어: "Microsoft Excel",
         장치명: "My-Mac",
         회사명: "Microsoft",
         시작일자: "2016-11-31",
         만료기간: "9999-99-99",
         상태: "발급완료|데모버전|발급대기|발급거절"
     }, ...]
     */
    var repeatData = function(data) {
        $("[data-repeat*='list']").repeat(data, function (dom, i, obj) {
            $(dom).find("[data-bind*='no']").html(obj['no']);
            $(dom).find("[data-bind*='소프트웨어']").html(obj['소프트웨어']);
            $(dom).find("[data-bind*='회사명']").html(obj['회사명']);
            $(dom).find("[data-bind*='요청일자']").html(obj['요청일자']);

            $(dom).find("[data-bind*='상태일반요청']").hide();
            $(dom).find("[data-bind*='상태데모요청']").hide();
            $(dom).find("[data-bind*='상태발급거절']").hide();

            if (obj['상태'] == "일반요청") {
                $(dom).find("[data-bind*='상태일반요청']").show();
            }

            if (obj['상태'] == "데모요청") {
                $(dom).find("[data-bind*='상태데모요청']").show();
            }

            if (obj['상태'] == "발급거절") {
                $(dom).find("[data-bind*='상태발급거절']").show();
            }
        });
    };

    // 초기데이터를 요청합니다.
    requestData();
</script>

<jsp:include page="include/_footer.jsp" />
