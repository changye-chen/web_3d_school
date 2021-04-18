/**
 * @param options 弹窗基本配置信息
 * @constructor 构造方法
 */
function PersonalCenter(options) {
    this.options = options ;
}
/**
 * 打开弹窗
 */
PersonalCenter.prototype.openLayer = function () {
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
    if(this.options.completed_num === undefined || this.options.completed_num === 0) {
        open_layer.style.background = "url(static/images/personal_0.png) no-repeat";
    }
    else if(this.options.completed_num === 1) {
        open_layer.style.background = "url(static/images/personal_1.png) no-repeat";
    }
    else if(this.options.completed_num === 2) {
        open_layer.style.background = "url(static/images/personal_2.png) no-repeat";
    }
    else if(this.options.completed_num === 3) {
        open_layer.style.background = "url(static/images/personal_3.png) no-repeat";
    }
    open_layer.style.display = "none";
    open_layer.style.position = "fixed";
    open_layer.style.top="20%";
    open_layer.style.left="0";
    open_layer.style.right="0";
    open_layer.style.margin="0 auto";
    // open_layer.style.top = this.options.top === undefined ? "10%" : this.options.top;
    // open_layer.style.left = this.options.left === undefined ? "10%" :this.options.left;
    // open_layer.style.width = this.options.width === undefined ? "80%" : this.options.width;
    // open_layer.style.height = this.options.height === undefined ? "80%" : this.options.height;
    open_layer.style.width = "350px";
    open_layer.style.height = "364px";
    open_layer.style.border = "1px solid";
    open_layer.style.borderRadius = "15px" ;
    open_layer.style.boxShadow = "4px 4px 10px #171414";;
    open_layer.style.zIndex = "1002";
    open_layer.style.overflow = "auto";



    //关闭
    var span_close = document.createElement("img");
    span_close.src = "static/images/close.png";
    span_close.style.position="absolute";
    span_close.style.width = "25px";
    span_close.style.height = "30px";
    span_close.style.right = "0";
    span_close.onmouseover = function(){
        //提示信息

    }
    span_close.onclick = function () {
        open_layer.style.display = "none";
        background_layer.style.display = "none";
    };

    open_layer.appendChild(span_close);


    var div_content = document.createElement("div");

    div_content.style.textAlign = "center";
    div_content.style.fontSize = "16px";
    div_content.style.color = "white";
    div_content.appendChild(document.createElement("br"));
    div_content.appendChild(document.createElement("br"));
    div_content.appendChild(document.createElement("br"));
    div_content.appendChild(document.createElement("br"));
    var content_area1 = document.createTextNode(this.options.content1 === undefined ? "" : this.options.content1);
    div_content.appendChild(content_area1);
    div_content.appendChild(document.createElement("br"));
    var content_area2 = document.createTextNode(this.options.content2 === undefined ? "" : this.options.content2);
    div_content.appendChild(content_area2);
    div_content.appendChild(document.createElement("br"));
    var content_area3 = document.createTextNode(this.options.content3 === undefined ? "" : this.options.content3);
    div_content.appendChild(content_area3);
    open_layer.appendChild(div_content);
    document.body.appendChild(open_layer);
    document.body.appendChild(background_layer);
    open_layer.style.display = "block" ;
    background_layer.style.display = "block";
};