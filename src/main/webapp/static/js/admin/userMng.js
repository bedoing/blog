var $table = $('#_userMngList'),
	/*$remove = $('#_userRemove'),*/
	$userAdd = $('#_userAdd'),
	selections = [];

$().ready(function(){
	

	initTable();
});


var initTable = function(){
	$table.bootstrapTable({
		url: PRE_URI + 'user/getUserList',
	    columns: [/*{
            field: '',
            checkbox: true,
            align: 'center',
            valign: 'middle'
        }, */{
	        field: 'loginAccount',
	        title: 'Login Account',
	        editable: {
                type: 'text',
                title: 'Account',
                validate: function (value) {
                    /*value = $.trim(value);
                    if (!value) {
                        return 'This field is required';
                    }
                    if (!/^$/.test(value)) {
                        return 'This field needs to start width $.'
                    }
                    var data = $table.bootstrapTable('getData'),
                        index = $(this).parents('tr').data('index');
                    console.log(data[index]);
                    return '';*/
                }
            },
	        footerFormatter: totalTextFormatter
	    }, {
	        field: 'sexStr',
	        title: 'Sex',
	        footerFormatter: totalNameFormatter,
	    }, {
	        field: 'createTimeStr',
	        title: 'Create Date',
	        sortable: true
	    }, {
	        field: 'statusStr',
	        title: 'Status'
	    }, {
	        field: 'createTimeStr',
	        title: 'Operate',
	        align: 'center',
	        events: operateEvents,
	        formatter: operateFormatter
	    }]
	});

	// sometimes footer render error.
    setTimeout(function () {
        $table.bootstrapTable('resetView');
    }, 200);
    /*$table.on('check.bs.table uncheck.bs.table ' +
            'check-all.bs.table uncheck-all.bs.table', function () {
        $remove.prop('disabled', !$table.bootstrapTable('getSelections').length);

        // save your data, here just save the current page
        selections = getIdSelections();
        // push or splice the selections if you want to save all data selections
    });*/
    $table.on('expand-row.bs.table', function (e, index, row, $detail) {
        if (index % 2 == 1) {
            $detail.html('Loading from ajax request...');
            $.get('LICENSE', function (res) {
                $detail.html(res.replace(/\n/g, '<br>'));
            });
        }
    });
    $table.on('all.bs.table', function (e, name, args) {
        console.log(name, args);
    });
    /*$remove.click(function () {
        var ids = getIdSelections();
        $table.bootstrapTable('remove', {
            field: 'id',
            values: ids
        });
        $remove.prop('disabled', true);
    });*/
	
	$userAdd.click(function () {
        // var ids = getIdSelections();
        
    });

    $(window).resize(function () {
        $table.bootstrapTable('resetView', {
            height: getHeight()
        });
    });
}

function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id
    });
}

function responseHandler(res) {
    $.each(res.rows, function (i, row) {
        row.state = $.inArray(row.id, selections) !== -1;
    });
    return res;
}

function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}

function operateFormatter(value, row, index) {
    return [
        '<a class="like" href="javascript:void(0)" title="Like">',
        '<i class="glyphicon glyphicon-heart"></i>',
        '</a>  ',
        '<a class="remove" href="javascript:void(0)" title="Control">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}

window.operateEvents = {
    'click .like': function (e, value, row, index) {
        console.log("likelikelike")
        alert('You click like action, row: ' + JSON.stringify(row));
        
    },
    'click .remove': function (e, value, row, index) {
    	console.log("removeremoveremove")
        $table.bootstrapTable('remove', {
            field: 'id',
            values: [row.id]
        });
    }
};

function totalTextFormatter(data) {
    return 'Total';
}

function totalNameFormatter(data) {
    return data.length;
}

function totalPriceFormatter(data) {
    var total = 0;
    $.each(data, function (i, row) {
        total += +(row.price.substring(1));
    });
    return '$' + total;
}

function getHeight() {
    return $(window).height() - $('h1').outerHeight(true);
}