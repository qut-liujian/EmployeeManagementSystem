<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" type="text/css"
		  href="bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<table class="table table-striped table-hover table-bordered">
	<thead>
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>电话</td>
		<td>领导</td>
		<td>操作</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${emps }" var="emp">
		<tr>
			<td>${emp.id }</td>
			<td>${emp.emp_name }</td>
			<td>${emp.emp_sex }</td>
			<td>${emp.emp_tel }</td>
			<td>${emp.leader_name }</td>
			<td>
				<a href="#" onclick="del(${emp.id},'${emp.emp_name }')">删除</a>
				<a href="#" onclick="edit(${emp.id },'${emp.emp_name }','${emp.emp_sex }','${emp.emp_tel }')">修改</a>
			</td>
		</tr>
	</c:forEach>

	</tbody>
</table>
<!-- 删除的模态框 -->
<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">提示</h4>
			</div>
			<div class="modal-body">
				您确定要删除【<span id="del_name"></span>】吗?
				<input type="hidden" id="del_no">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" onclick="doDel()">确定</button>
			</div>
		</div>
	</div>
</div>
<!-- 修改的模态框 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">修改信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<input type="hidden" id="u_no">
					<div class="form-group">
						<label class="control-label col-sm-2">用户名:</label>
						<div class="col-sm-6">
							<input type="text" id="u_name" class="form-control"  />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">性别:</label>
						<div class="col-sm-6">
							<select id="u_sex" class="form-control">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">电话:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="u_tel" />
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" onclick="doEdit()">确定</button>
			</div>
		</div>
	</div>
</div>
</body>
<script src="js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function del(no,name)
	{
		jQuery("#del_no").val(no);
		jQuery("#del_name").html(name);
		jQuery("#delModal").modal("show");
	}
	function doDel()
	{
		var no=jQuery("#del_no").val();
		jQuery.post("DelServlet",{"id":no},function(rst){
			if(rst=="1")
			{
				alert("删除成功！");
			}else{
				alert("删除失败！")
			}
			jQuery("#delModal").modal("hide");
			window.location.href="ToEmpsServlet";
		});
	}
	function edit(no,name,sex,tel)
	{
		jQuery("#u_no").val(no);
		jQuery("#u_name").val(name);
		jQuery("#u_sex").val(sex);
		jQuery("#u_tel").val(tel);
		jQuery("#editModal").modal("show");
	}
	function  doEdit() {
		var no=jQuery("#u_no").val();
		var name=jQuery("#u_name").val();
		var sex=jQuery("#u_sex").val();
		var tel=jQuery("#u_tel").val();
		jQuery.post("EditServlet",{"id":no,"name":name,"sex":sex,"tel":tel},function(rst){
			if(rst=="1")
			{
				alert("修改成功！");
			}else{
				alert("修改失败！")
			}
			jQuery("#editModal").modal("hide");
			window.location.href="ToEmpsServlet";
		});
	}
</script>
</html>
