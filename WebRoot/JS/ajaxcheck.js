
//验证类别名是否已经存在 
function JudgeUserName()
        {
            $.ajax({
            type:"GET",
            url:"checktype.do",
            dataType:"jsp",
            data:"typename="+$("#typename").val().trim(),
            beforeSend:function(XMLHttpRequest)
                {
                    $("#showResult").text("正在查询");
                    //Pause(this,100000);
                },
            success:function(msg)
                {   
                    $("#showResult").html(msg);
                },
           complete:function(XMLHttpRequest,textStatus)
                {
                    //隐藏正在查询图片
                },
          error:function()
               {
        	  $("#showResult").html("ajaxerror");
               }
            });
        }
