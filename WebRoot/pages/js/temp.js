function UpladFile() {
            var fileObj = document.getElementById("file").files[0]; // 获取文件对象
            var FileController = "../file/save";                    // 接收上传文件的后台地址
            // FormData 对象
            var form = new FormData();
            form.append("author", "hooyes");                        // 可以增加表单数据
            form.append("file", fileObj);                           // 文件对象
            // XMLHttpRequest 对象
            var xhr = new XMLHttpRequest();
            xhr.open("post", FileController, true);
            xhr.onload = function () {
                alert("上传完成!");
            };
            xhr.send(form);
        }