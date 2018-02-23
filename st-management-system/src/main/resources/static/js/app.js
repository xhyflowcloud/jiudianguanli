new Vue({
    el: "body",
    data: function() {
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.ruleInline.password) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        var email = (rule, value, callback) => {
            let mal = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            if (!value) {
                return callback(new Error('不能为空'));
            }
            if(!(mal.test(value))) {
                callback(new Error('请输入正确邮箱'));
            }else{
                callback();
            }
        };
        return {
            ruleInline: {
                user: [{
                    required: true,
                    message: '请填写用户名',
                }],
                password: [{
                    required: true,
                    message: '请填写密码',
                    trigger: 'blur',
                }, {
                    type: 'string',
                    min: 6,
                    message: '密码长度不能小于6位',
                    trigger: 'blur',
                }],
                repassword:[{
                    required: true,
                    message: '请填写确认密码',
                    trigger: 'blur',
                }, {
                    validator: validatePass,
                    trigger: 'blur',
                }],
                email:[{
                    required: true,
                    message: '请填写邮箱',
                    trigger: 'blur',
                },{
                    validator: email,
                    triger: 'blur',
                }]
            },
            theme: 'dark',
            loginVisible: false,
            registerVisible:false,
        }
    },
    methods: {
        handleSubmit: function(name) {
            this.$refs[name].validate(function(valid) {
                if (valid) {
                    this.$Message.success('提交成功!');
                } else {
                    this.$Message.error('表单验证失败!');
                }
            }.bind(this));
            //bind 是改变一个函数的this指向；这儿就是把function(valid)内部的this指向改成外面vue 的this（this劫持）
        },
        handleReset: function(name) {
            this.loginVisible = false;
            this.registerVisible=false;
        },
        login: function(){
            this.loginVisible = true;
            this.registerVisible=false;
        },
        register: function () {
            this.loginVisible = false;
            this.registerVisible=true;
        }
    }
})
