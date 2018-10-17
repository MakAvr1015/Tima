/**
 * 
 */

$(document).ready(function() {

	$('#docOutList').dataTable({
		retrieve : true,
		select : true,
		select : {
			style : 'single'
		},

		'bProcessing' : true,
		'bServerSide' : true,
		ajaxSource : './DocList',
		columns : [ {
			data : 'f_id',
			width: '5%'
		}, {
			data : 'f_number'
		}, {
			data : 'f_date'
		}, {
			data : 'f_sender_name'
		}, {
			data : 'f_recip_name'
		}, {
			data : 'f_sum'
		}, {
			data : 'f_state_name'
		} ]
	// 'sAjaxSource': './DocList',
	// 'bJQueryUI': true,
	// 'aoColumns': [
	// { mData: 'f_id',
	// sWidth: '5%'},
	// { mData: 'f_number'},
	// { mData: 'f_date'},
	// { mData: 'f_sender_name'},
	// { mData: 'f_recip_name'},
	// { mData: 'f_sum'},
	// { mData: 'f_state_name'},
	// ]
	});

});
