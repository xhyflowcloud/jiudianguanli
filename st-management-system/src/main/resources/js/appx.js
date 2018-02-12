
var view_js = new Vue({
    el: '#app',
    data: {
        visible: false
    },
    methods: {
        show: function () {
            this.visible = true;
        }
    }
});