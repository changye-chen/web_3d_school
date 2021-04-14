/**
 * @param options 弹窗基本配置信息
 * @constructor 构造方法
 */
function Reminder(options) {
    this.options = options ;
}
/**
 * 打开弹窗
 */
Reminder.prototype.openLayer = function () {
    var background_layer = document.createElement("div");

    background_layer.style.display = "none";
    background_layer.style.position = "absolute";
    background_layer.style.top =  "0px";
    background_layer.style.left = "0px";
    background_layer.style.width = "100%";
    background_layer.style.height = "100%";
    background_layer.style.backgroundColor = "gray";
    background_layer.style.zIndex = "1001";
    background_layer.style.opacity = "0.8" ;


    var open_layer = document.createElement("div");
    open_layer.style.background = "url(static/images/reminder.png) no-repeat";
    open_layer.style.display = "none";
    open_layer.style.position = "fixed";
    open_layer.style.top="10%";
    open_layer.style.left="0";
    open_layer.style.right="0";
    open_layer.style.margin="0 auto";
    // open_layer.style.top = this.options.top === undefined ? "10%" : this.options.top;
    // open_layer.style.left = this.options.left === undefined ? "10%" :this.options.left;
    // open_layer.style.width = this.options.width === undefined ? "80%" : this.options.width;
    // open_layer.style.height = this.options.height === undefined ? "80%" : this.options.height;
    open_layer.style.width = "300px";
    open_layer.style.height = "223px";
    open_layer.style.border = "1px solid";
    open_layer.style.borderRadius = "15px" ;
    open_layer.style.boxShadow = "4px 4px 10px #171414";;
    open_layer.style.zIndex = "1002";
    open_layer.style.overflow = "auto";



    //确认
    var span_confirm = document.createElement("img");
    span_confirm.src = "static/images/confirm.png";
    span_confirm.style.position="absolute";
    span_confirm.style.width = "54px";
    span_confirm.style.height = "23px";
    span_confirm.style.right = "0";
    span_confirm.style.bottom = "0";
    span_confirm.onmouseover = function(){
        //提示信息

    }
    span_confirm.onclick = function () {
        open_layer.style.display = "none";
        background_layer.style.display = "none";
    };

    open_layer.appendChild(span_confirm);


    // //接受任务
    // var span_accept_mission = document.createElement("img");
    // span_accept_mission.src = "./imag/accept.png";
    // span_accept_mission.style.position="absolute";
    // span_accept_mission.style.width = "100px";
    // span_accept_mission.style.height = "100px";
    // span_accept_mission.style.left = "0";
    // span_accept_mission.style.bottom = "0";
    // span_accept_mission.onmouseover = function(){
    // 	//接受任务提示信息
    // }
    // span_accept_mission.onclick = this.options.test;
    // open_layer.appendChild(span_accept_mission);



    var div_content = document.createElement("div");
    div_content.style.display="none";
    div_content.style.textAlign = "center";
    div_content.style.fontSize = "16px";
    div_content.style.color = "white";
    div_content.appendChild(document.createElement("br"));
    div_content.appendChild(document.createElement("br"));
    div_content.appendChild(document.createElement("br"));
    div_content.appendChild(document.createElement("br"));
    var content_area = document.createTextNode(this.options.content === undefined ? "" : this.options.content);
    div_content.appendChild(content_area);
    open_layer.appendChild(div_content);
    document.body.appendChild(open_layer);
    document.body.appendChild(background_layer);
    open_layer.style.display = "block" ;
    background_layer.style.display = "block";
    div_content.style.display="block";
};