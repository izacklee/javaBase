/**
 * Created by Administrator on 2021/2/19.
 */
$(".sousouInput").blur(function(){
    $(".sousuo").css({
        border:"1px solid #ccc"
    });
    $(".ss1").removeClass("focusState");
});
$(".sousouInput").focus(function(){
    $(".sousuo").css({
        border:"1px solid #9cf"
    });
    $(".ss1").addClass("focusState");
});
$(".zuijinTitle").css({
    width:$(window).width()-237
});
$(".content").css({
   width:$(window).width()-237
});

$("#page_content").css({
    width:$(window).width()-237
});

$(".allIcon").click(function(){
    if($(this).attr("data-all")=="yes"){
        $(this).attr("src","images/select.png");
        $(".select").attr("src","images/select.png");
        $(this).attr("data-all","no");
        $(".template").attr("data-show","no");
        $(".template").removeClass("box2H");
    }else{
        $(this).attr("src","images/selectC.png");
        $(".template").attr("data-show","yes");
        $(this).attr("data-all","yes");
        $(".template").addClass("box2H");
        $(".select").attr("src","images/selectC.png");
    }
});

bindMyClick();

function  bindMyClick(){
    // $(".fileList .template").each(function(){
        // 委托事件
        $(".fileList").on('click','.template', function(){
           if($(this).attr("data-show")=="yes"){
               $(this).removeClass(".box2C");
               $(this).removeClass(".box2H");
               $(this).find(".select").attr("src","images/select.png");
               $(this).attr("data-show","no");

           }else {
               $(this).addClass(".box2C");
               $(this).addClass(".box2H");
               $(this).find(".select").attr("src","images/selectC.png");
               $(this).attr("data-show","yes");
               $(this).find(".select").show();
           }
       });
    // });
}


$(".contentMain .templateUrl").each(function(e){
    $(".contentMain .templateUrl").eq(e).click(function(){
        $(".contentMain p").removeClass("templateUrlClickP");
        $(".contentMain p").eq(e).addClass("templateUrlClickP");
   });
});

$(".yidong").click(function(){
    $(".moveBox").show();
});

$(".closeMove,.ok,.quxiao").click(function(){
    $(".moveBox").hide();
});