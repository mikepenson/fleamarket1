

function changeImg(){  
    var imgSrc = $("#imgObj");  
    var src = imgSrc.attr("src");  
    imgSrc.attr("src",chgUrl(src));  
}  
//ʱ���  
//Ϊ��ʹÿ������ͼƬ��һ�£�����������������棬������Ҫ����ʱ���  
function chgUrl(url){  	
    var timestamp = (new Date()).valueOf();
    url = url + "?tamp=" + timestamp;  
    return url;  
} 

function isRightCode(){  
    var code = $("#veryCode").attr("value");  
    code = "veryCode=" + code;  
    $.ajax({  
        type:"POST",  
        url:"verifycode_checkVerifyCode.action",  
        data:code,  
        success:callback  
    });  
}    
function callback(data){  
    $("#info").html(data);  
}  