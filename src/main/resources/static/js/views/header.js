window.HeaderView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },
    events: {
        "click .menu-item"   : "selectMenuItem"
    },
    render: function () {
        var that = this;
        $.get("tpl/HeaderView.html", function (template) {
            var tmp = $.tmpl(template);
            that.$el.html(tmp);
        });
        return this;
    },

    selectMenuItem: function (menuItem) {
        $(this).removeClass('active');
        if (menuItem) {
            $('.' + menuItem).addClass('active');
        }
    }

});