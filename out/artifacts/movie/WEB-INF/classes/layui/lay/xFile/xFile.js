/**
 * xFile 文件上传组件，支持图片裁剪
 * author: imlzw
 * url: adai.imlzw.cn
 * 配置参数：
 *
 */

layui.define(['layer', 'jquery', 'upload'], function (exports) {
        var $ = layui.jquery;
        let upload = layui.upload;
        let element = layui.element;
        let imgExts = "art|bmp|dib|gif|ico|ief|jpe|jpeg|jpg|mac|pbm|pct|pgm|pic|pict|png|pnm|pnt|ppm|psd|qti|qtif|ras|rgb|svg|svgz|tif|tiff|wbmp|xbm|xpm|xwd";
        let fileExts = "";

        let XFile = function () {
            this.v = '1.0.0';
            this.renderIns = {};
            this.imageExtRegx = /art|bmp|dib|gif|ico|ief|jpe|jpeg|jpg|mac|pbm|pct|pgm|pic|pict|png|pnm|pnt|ppm|psd|qti|qtif|ras|rgb|svg|svgz|tif|tiff|wbmp|xbm|xpm|xwd/i;
        }

        // 默认配置
        let defaultConfig = {
            id: undefined, // 渲染的元素id
            // base: "", // xFile组件的web访问路径，用于加载其它js,css使用，默认当前路径
            url: undefined, // 服务端上传接口，返回的数据规范请详见下文
            data: undefined, //请求上传接口的额外参数。如：data: {id: 'xxx'} , 从 layui 2.2.6 开始，支持动态表达式值
            headers: undefined, //接口的请求头。如：headers: {token: 'sasasas'}。注：该参数为 layui 2.2.6 开始新增
            // accept: 'images', //指定允许上传时校验的文件类型，可选值有：images（图片）、file（所有文件）、video（视频）、audio（音频）
            // acceptMime: 'image/*', //规定打开文件选择框时，筛选出的文件类型，值为用逗号隔开的 MIME 类型列表。如： acceptMime: 'image/*'（只显示图片文件） acceptMime: 'image/jpg, image/png'（只显示 jpg 和 png 文件） 注：该参数为 layui 2.2.6 开始新增
            // exts: imgExts,//'jpg|png|gif|bmp|jpeg', //允许上传的文件后缀。一般结合 accept 参数类设定。假设 accept 为 file 类型时，那么你设置 exts: 'zip|rar|7z' 即代表只允许上传压缩格式的文件。如果 accept 未设定，那么限制的就是图片的文件格式
            auto: false, //是否选完文件后自动上传。如果设定 false，那么需要设置 bindAction 参数来指向一个其它按钮提交上传
            multiple: false, // 是否允许多文件上传。设置 true即可开启。不支持ie8/9 默认：false
            size: 0, //设置文件最大可允许上传的大小，单位 KB。不支持ie8/9, 0（即不限制）
            field: 'file', //设定文件域的字段名
            bindAction: false, //指向一个按钮触发上传，一般配合 auto: false 来使用。值为选择器或DOM对象，如：bindAction: '#btn',string/object
            drag: true, // 是否接受拖拽的文件上传，设置 false 可禁用。不支持ie8/9
            choose: function (object) {
                return object;
            }, //选择文件后的回调函数。返回一个object参数，详见下文
            before: function (object) {
                return object;
            },  //文件提交上传前的回调。返回一个object参数（同上），详见下文	function	-
            progress: function (res, index, upload) {
                return res;
            }, // 文件上传进度回调函数
            done: function (res, index, upload) {
                return res;
            }, //	执行上传请求后的回调。返回三个参数，分别为：res（服务端响应信息）、index（当前文件的索引）、upload（重新上传的方法，一般在文件上传失败后使用）。详见下文	function	-
            error: function (index, upload) {
            }, //执行上传请求出现异常的回调（一般为网络异常、URL 404等）。返回两个参数，分别为：index（当前文件的索引）、upload（重新上传的方法）。详见下文	function
            // rewriteFormValue: function(values){ return JSON.stringify(values) }, // 默认重写表单值参数
            number: 0, // 设置同时可上传的文件数量，一般配合 multiple 参数出现。 注意：该参数为 layui 2.2.3 开始新增 number	0（即不限制）
            cropImages: true, // 是否裁剪图片
            cropWidth: 180, // 裁剪图片宽度
            cropHeight: 180, // 裁剪图片高度
        }

        /**
         * 渲染图片文件裁剪组件
         *
         * @param config 配置
         * @param chooseFile 当前选择上传的需要被裁剪的文件
         * @param index 当前文件的索引
         * @param $blockImg 当前文件展示的页面元素对象
         * @param uploadInst 上传组件渲染实例
         * @param isChooseFileEvent 是否是选择文件事件
         */
        function renderImageFileCropper(config, chooseFile, index, $blockImg, uploadInst, isChooseFileEvent) {
            // first = false;
            let $cropImagesElem = config.cropImagesElem.clone();
            let $cropImg = $('.x-file-cropper-img', $cropImagesElem);
            let $preSquareImg = $('.x-file-cropper-preview-img-square > img', $cropImagesElem);
            let $preCircleImg = $('.x-file-cropper-preview-img-circle > img', $cropImagesElem);
            let $cropBtn = $('.x-file-crop-btn', $cropImagesElem);
            $cropImg.attr('src', $blockImg.attr("src"));
            const cropper = new Cropper($cropImg[0], {
                aspectRatio: config.cropWidth / config.cropHeight,
                crop(event) {
                    let cropData = cropper.getCroppedCanvas({width: config.cropWidth, height: config.cropHeight}).toDataURL('image/png');
                    $preSquareImg.attr('src', cropData);
                    $preCircleImg.attr('src', cropData);
                }
            });
            // 裁剪点击事件
            $cropBtn.click(function () {
                let croppedCanvas = cropper.getCroppedCanvas({width: config.cropWidth, height: config.cropHeight});
                croppedCanvas.toBlob(function (blob) {
                    const newFile = new window.File(
                        [blob],
                        chooseFile.name,
                        {type: chooseFile.type}
                    );
                    $blockImg.attr('src', croppedCanvas.toDataURL('image/jpeg'));
                    if (config.auto) {
                        let uploadFiles = {};
                        uploadFiles[index] = newFile;
                        uploadInst.upload(uploadFiles);
                    }
                    layui.layer.close($cropBtn.layerIndex);
                })
            })
            $cropImagesElem.appendTo($('body'));
            $cropBtn.layerIndex = layui.layer.open({
                type: 1,
                area: ['720px', '500px'],
                title: false,
                content: $cropImagesElem,
                cancel: function (idx, layero) {
                    // 首次选择文件上传时
                    if (config.auto && isChooseFileEvent) {
                        layui.layer.confirm('确定不裁剪进行上传吗？', {
                            btn: ['直接上传', '返回裁剪'] //按钮
                        }, function () {
                            let uploadFiles = {};
                            uploadFiles[index] = chooseFile;
                            uploadInst.upload(uploadFiles);
                            layui.layer.close(idx);
                            layui.layer.close(layui.layer.index);
                        }, function () {
                            //
                        })
                        return false
                    } else {
                        layui.layer.close(idx);
                    }
                }
            });
        }

        /**
         * 下载url文件
         *
         * @param url
         * @param name
         */
        function downloadUrl(url, name) {
            const elt = document.createElement('a');
            elt.setAttribute('href', url);
            elt.setAttribute('download', name);
            elt.style.display = 'none';
            document.body.appendChild(elt);
            elt.click();
            document.body.removeChild(elt);
        }

        /**
         * 渲染文件展示块
         *
         * @param $fileBlock 文件展示块模板元素对象
         * @param file 当前要展示的文件对象
         * @param uploadInst 传组件渲染实例
         * @param index 当前文件的索引
         * @param $uploadBtn 上传组件上传按钮的元素对象
         * @param config 配置
         * @param elId 渲染元素的id
         * @param isChooseFileEvent 是否是选择文件事件
         */
        function renderFileBlock($fileBlock, file, uploadInst, index, $uploadBtn, config, elId, isChooseFileEvent) {
            let $fileBlockCopy = $fileBlock.clone();
            $(".x-file-name", $fileBlockCopy).html(file.name);
            $fileBlockCopy.attr("title", file.name);
            // 添加文件预览块删除事件
            $('.x-file-oper-del', $fileBlockCopy).click(function () {
                let $this = $(this);
                delete uploadInst.blocks[index];
                delete uploadInst.datas[index];
                uploadInst.computerFormValue();
                $fileBlockCopy.remove();
                if (Object.keys(uploadInst.blocks).length <= 0) {
                    $uploadBtn.show();
                }
            });
            let $blockImg = $("img", $fileBlockCopy);
            // 添加文件预览块编辑事件
            if (file.type.indexOf("image/") >= 0) {
                if (window.FileReader) {
                    var reader = new FileReader();
                    reader.readAsDataURL(file);
                    reader.onload = function () {
                        if (isChooseFileEvent) {
                            $blockImg.attr('src', this.result);
                        }
                        let previewImg = function () {
                            layui.layer.photos({
                                photos: {
                                    id: 1,
                                    start: 0,
                                    title: '',
                                    data: [
                                        {
                                            alt: file.name,
                                            pid: 666,
                                            src: $blockImg.attr("src"),
                                        }
                                    ]
                                }
                            })
                        };

                        let downloadImg = function () {
                            downloadUrl($blockImg.attr("src"), file.name);
                        }

                        $('.x-file-preview', $fileBlockCopy).click(previewImg).css("cursor", "pointer");
                        $('.x-file-oper-view', $fileBlockCopy).click(previewImg).show();
                        $('.x-file-oper-download', $fileBlockCopy).click(downloadImg).show();
                        // 是否裁剪图片？
                        if (config.cropImages) {
                            let $imgEditBtn = $('.x-file-oper-edit', $fileBlockCopy);
                            $imgEditBtn.click(function () {
                                renderImageFileCropper(config, new window.File([], file.name, {type: file.type}), index, $blockImg, uploadInst, false);
                            }).show();
                            if (isChooseFileEvent) {
                                renderImageFileCropper(config, file, index, $blockImg, uploadInst, true);
                            }
                        }
                    }
                } else {
                    $('.x-file-oper-download', $fileBlockCopy).click(function(){
                        downloadUrl(URL.createObjectURL(file), file.name);
                    }).show();
                    $blockImg.attr('src', config.base + "img/file.svg").addClass("x-file-icon");
                }
            } else {
                let downloadFile = function () {
                    if (file.file_url) {
                        downloadUrl(file.file_url, file.name);
                    } else {
                        downloadUrl(URL.createObjectURL(file), file.name);
                    }
                }
                $('.x-file-oper-download', $fileBlockCopy).click(downloadFile).show();
                $blockImg.attr('src', config.base + "img/file.svg").addClass("x-file-icon");
            }
            let $progress = $(".x-file-progress", $fileBlockCopy);
            $progress.attr("id", elId + '_progress_' + index);
            if (!isChooseFileEvent) {
                $progress.hide();
            }
            $uploadBtn.before($fileBlockCopy);
            uploadInst.blocks[index] = $fileBlockCopy;
            if (file.item) {
                uploadInst.datas[index] = file.item;
            }
            if (!config.multiple) {
                $uploadBtn.hide();
            }
        }

        /**
         * 渲染组件
         * @param config
         */
        XFile.prototype.render = function (config) {
            config = {...defaultConfig, ...config};
            if (config.accept && (!config.acceptMime || !config.exts)) {
                switch (config.accept) {
                    case 'images':
                        config.acceptMime = !config.acceptMime ? "image/*" : config.acceptMime;
                        config.exts = !config.exts ? imgExts : config.acceptMime;
                    default:

                }
            }
            let that = this;

            config.base = config.base ? config.base.endsWith("/") ? config.base : config.base + "/" : '/';
            that.loadCss(config.base + "css/xFile.css");
            if (config.cropImages) {
                that.loadCss(config.base + "cropper/cropper.min.css");
                that.loadJS(config.base + "cropper/cropper.min.js");
                config.cropImagesElem = $(`
                    <div class="x-file-cropper">
                        <div class="x-file-cropper-img-container">
                            <img class="x-file-cropper-img">
                        </div>
                        <div class="x-file-cropper-preview-img-square">
                            <img class="x-file-preview-img">
                        </div>
                        <div class="x-file-cropper-preview-img-circle">
                            <img class="x-file-preview-img">
                        </div>
                        <button type="button" class="layui-btn x-file-crop-btn">裁剪</button>
                    </div>
                `);
                config.cropImagesElem.hide();//.appendTo($('body'));
            }
            let $textInput = $('#' + config.id);
            if (!$textInput[0]) {
                console.warn("渲染文件上传的目标不存在！id=" + config.id);
                return;
            }
            let initValueJson = $textInput.val();
            let initValues;
            if (initValueJson != null) {
                try {
                    initValues = JSON.parse(initValueJson);
                } catch (e) {
                    console.warn("转化XFile初始值为json失败！", initValueJson)
                }
            }
            if (config.initValues) {
                initValues = config.initValues;
            }
            let multiFile = config.multiFile;
            let $parent = $textInput.parent();
            let elId = $textInput.attr("id");

            $parent[0].removeChild($textInput[0]);

            let $newElem = $(`<div fileId="${elId}" class="x-file"></div>`);
            let $fileBlock = $(`
                <div class="x-file-block">
                    <img src="" class="x-file-preview" alt="文件预览图"></img>
                    <div class="x-file-oper x-file-progress">
                      <div class="x-file-progress-bar layui-bg-green" ></div>
                      <div class="x-file-progress-info">未上传</div>
                    </div>
                    <div src="" class="x-file-info">
                        <span class="x-file-name"></span>
                    </div>
                    <div class="x-file-opers">
                        <i class="x-file-oper x-file-oper-view layui-icon layui-icon-search" title="预览"></i>
                        <i class="x-file-oper x-file-oper-edit layui-icon layui-icon-edit" title="编辑"></i>
                        <i class="x-file-oper x-file-oper-download layui-icon layui-icon-download-circle" title="下载"></i>
                        <i class="x-file-oper x-file-oper-del layui-icon layui-icon-delete" title="删除"></i>
                    </div>
                </div>
            `);
            let $uploadBtn = $(`
                <button type="button" class="layui-btn x-file-upload" id="${elId}_upload_btn">
                  <i class="layui-icon">&#xe67c;</i>上传
                </button>
            `);
            $textInput.attr("type", "hidden");
            $newElem.append($textInput);
            $newElem.append($uploadBtn);
            $parent.append($newElem)


            var uploadInst = upload.render({
                elem: '#' + config.id + "_upload_btn",
                url: config.url, //改成您自己的上传接口
                ...config,
                auto: config.cropImages ? false : config.auto,
                choose: function (obj) {
                    //将每次选择的文件追加到文件队列
                    var files = obj.chooseFiles;
                    uploadInst.files = obj.chooseFiles;
                    layui.each(files, function (index, file) {
                        renderFileBlock($fileBlock, file, uploadInst, index, $uploadBtn, config, elId, true);
                    });
                    config.choose && config.choose(obj);
                    if (!config.multiple && files != null && Object.keys(files).length > 0) {
                        $uploadBtn.hide();
                    }
                    // 如果有图片裁剪，并且自动上传，这里需要将非图片上传一下
                    if (config.auto && config.cropImages) {
                        layui.each(files, function (index, file) {
                            if (file.type.indexOf("image/") < 0) {
                                let uploadFiles = {};
                                uploadFiles[index] = file;
                                uploadInst.upload(uploadFiles);
                            }
                        })
                    }
                },
                progress: function (n, elem, index) {
                    var percent = n + '%' //获取进度百分比
                    // console.log("progress", index, percent, elem);
                    // 更新进度条
                    let $progress = $('#' + elId + '_progress_' + index);
                    $progress.show();
                    $('.x-file-progress-bar', $progress).css({width: percent});
                    $('.x-file-progress-info', $progress).text('上传中 ' + percent);
                    if (config.progress) {
                        config.progress(index, upload)
                    }
                    // element.progress('demo', percent); //可配合 layui 进度条元素使用
                    //以下系 layui 2.5.6 新增
                    // console.log(elem); //得到当前触发的元素 DOM 对象。可通过该元素定义的属性值匹配到对应的进度条。
                },
                done: function (res, index, upload) {
                    // console.log('done', res, index, upload);
                    //如果上传失败
                    if (!res.success) {
                        let $progress = $(`#${elId}_progress_${index}`);
                        $('.x-file-progress-info', $progress).text('上传错误！');
                        return;
                    } else {
                        let data = res;
                        if (config.done) {
                            data = config.done(res, index, upload)
                        }
                        // 隐藏进度条
                        $(`#${elId}_progress_${index}`).hide();
                        // 记录返回值
                        uploadInst.datas[index] = {...(uploadInst.datas[index] || {}), ...data.data}
                        // 单文件上传，需要计算下
                        if (!config.multiple) {
                            uploadInst.computerFormValue();
                        }
                    }
                },
                allDone: function () {
                    uploadInst.computerFormValue();
                },
                error: function (index, upload) {
                    // 进度条
                    let $progress = $(`#${elId}_progress_${index}`);
                    $('.x-file-progress-info', $progress).text('上传错误！');
                    // $uploadBtn.removeClass("layui-btn-disabled");
                    // $uploadBtn.text("上传");
                    //演示失败状态，并实现重传
                    // var demoText = $('#demoText');
                    // demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                    // demoText.find('.demo-reload').on('click', function () {
                    //     uploadInst.upload();
                    // });
                },
            });
            uploadInst.values = initValues;
            uploadInst.blocks = {};
            uploadInst.datas = {};
            // 计算表单值
            uploadInst.computerFormValue = function () {
                let values = [];
                Object.keys(uploadInst.blocks).forEach(function (index) {
                    if (uploadInst.datas[index]) {
                        values.push(uploadInst.datas[index]);
                    }
                })
                uploadInst.values = values;
                if (config.rewriteFormValue) {
                    $textInput.val(config.rewriteFormValue(values))

                } else {
                    $textInput.val(JSON.stringify(values));
                }
            }
            // 初始值设置
            if (initValues) {
                initValues.forEach && initValues.forEach(function (item) {
                    let file = new File([], item.file_name, {type: that.imageExtRegx.test(item.file_suffix) ? 'image/*' : 'other/*'});
                    file.item = item;
                    file.file_url = item.file_url;
                    let $fileBlockCopy = $fileBlock.clone();
                    // 图片文件
                    if (that.imageExtRegx.test(item.file_suffix)) {
                        $("img", $fileBlockCopy).attr('src', initValueJson);
                    } else {
                        $("img", $fileBlockCopy).attr('src', config.base + "img/file.svg").addClass("x-file-icon");
                    }
                    let index = item.file_id;
                    renderFileBlock($fileBlockCopy, file, uploadInst, index, $uploadBtn, config, elId, false);
                });
            }
            that.renderIns[elId] = uploadInst;
            return uploadInst;
        }

        /**
         * 动态加载js文件
         * @param url
         * @param callback
         */
        XFile.prototype.loadJS = function (url, callback) {
            var script = document.createElement('script'),
                fn = callback || function () {
                };
            script.type = 'text/javascript';
            //IE
            if (script.readyState) {
                script.onreadystatechange = function () {
                    if (script.readyState == 'loaded' || script.readyState == 'complete') {
                        script.onreadystatechange = null;
                        fn();
                    }
                };
            } else {
                //其他浏览器
                script.onload = function () {
                    fn();
                };
            }
            script.src = url;
            document.getElementsByTagName('head')[0].appendChild(script);
        }

        /**
         * 加载css文件
         * @param url
         */
        XFile.prototype.loadCss = function (url) {
            if (!url || url.length === 0) {
                throw new Error('argument "url" is required !');
            }
            var head = document.getElementsByTagName('head')[0];
            var link = document.createElement('link');
            link.href = url;
            link.rel = 'stylesheet';
            link.type = 'text/css';
            head.appendChild(link);
        }

        exports('xFile', new XFile());
    }
);