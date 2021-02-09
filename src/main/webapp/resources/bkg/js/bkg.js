'use strict'
var bkg = bkg || {}
bkg = (() => {
	const booking = x => {
		$.ajax({
			url: `${x}/bookings`,
			type: `POST`,
			data: JSON.stringify({
				bookNum: 0,
                showTitle: $('#showTitle').val(),
                showDate: $('#showDate').val(),
                showLocation: $('#showLocation').val(),
                showPrice: $('#showPrice').val(),
				bookId: `abc123`,
				bookName: $('#bookName').val(),
				bookEmail: $('#bookEmail').val(),
				bookPnumber: $('#bookPnumber').val()
			}),
			dataType: 'json',
            contentType: 'application/json',
            success: d => {
                alert(`예약 완료`)
                location.href=`${x}/move/bkg/list`
            },
            error: e => { alert(`추가 실패: ${e}`)}
		})
	}
	const list = x => {	
	$('#home').click(e => {location.href=`${x.ctx}/`})
	$.getJSON(`${x.ctx}/bookings/list/${x.pageSize}/${x.pageNum}`, d => { 
		$(`<h3/>`)
		.attr({id: `title`})
		.appendTo(`#bkg-data`)
		$(`<table/>`)
		.attr({id: `tab`})
		.css({width: `100%`})
		.appendTo(`#title`) 
		$(`<tr/>`).attr({id: `tr_1`}).appendTo(`#tab`).css({height: `33px`})
		$.each([`예약번호`,`상품명`,`일시`,`장소`,`금액`, '예약자명'], 
		    (i, j) => {
			$(`<th>${j}</th>`).css({backgroundColor: `#c1c7c7`, fontSize: `16px`})
			.appendTo(`#tr_1`)
		})
		$.each(d.list, 
			(i, j) => {
			$(`<tr><td><a class="bookNum" href="#" id="${j.bookNum}">${j.bookNum}</a></td>
		   	    		<td>${j.showTitle}</td>
		   	    		<td>${j.showDate}</td>
						<td>${j.showLocation}</td>
						<td>${j.showPrice}</td>
						<td>${j.bookName}</td></tr>`)
						.css({padding: `20px`, textAlign: `center`, fontSize: `13px`, height: `25px`})
						.appendTo(`#tab`)
		})
		$('.bookNum').each(function(){
                    $(this).click(e => {
                        e.preventDefault()
                        localStorage.setItem('bookNum', `${this.id}`)
                        location.href=`${x.ctx}/move/bkg/detail`
                    })
                })
		$(`<div/>`)
		.attr({id: `bkg_page`})
		.addClass(`pagination`)
		.appendTo(`#bkg-data`)
		const page = d.page
		function* range(start, end){
			yield start;
			if(start === end) return;
			yield* range(start + 1, end);
		}
		if(page.existPrev){
			$(`<a/>`)
			.attr({href: `#`})
			.text(`<<`)
			.appendTo(`#bkg_page`)
			.click(e=>{
				e.preventDefault()
				$(`#bkg-data`).empty()
				bkg.list({ctx: x.ctx, pageSize: `10`, pageNum: page.prevBlock})
			})
		}
		$.each([...range(page.startPage, page.endPage)],
			(i, j) => {
			$(`<a/>`)
			.attr({href: `#`})
			.css({backgroundColor: (j !== page.pageNum) ? `#F8F8FF` : `#7ea3a3`})
			.text(`${j}`)
			.appendTo(`#bkg_page`)
			.click(e=> {
				e.preventDefault()
				$(`#bkg-data`).empty()
				bkg.list({ctx: x.ctx, pageSize: `10`, pageNum: j})
				})
		})
		if(page.existNext){
			$(`<a/>`)
			.attr({href: `#`})
			.text(`>>`)
			.appendTo(`#bkg_page`)
			.click(e=>{
				e.preventDefault()
				$(`#bkg-data`).empty()
				bkg.list({ctx: x.ctx, pageSize: `10`, pageNum: page.nextBlock})
			})
		}
	})
}
	const detail = x => {
        $.getJSON(`${x}/bookings/${localStorage.getItem('bookNum')}`, d => {
            $('#bNum').text(d.bookNum)
            $('#sTitle').text(d.showTitle)
            $('#sDate').text(d.showDate)
            $('#sLocation').text(d.showLocation)
            $('#sPrice').text(d.showPrice)
			$('#bId').text(d.bookId)
			$('#bName').text(d.bookName)
			$('#bEmail').text(d.bookEmail)
			$('#bPnumber').text(d.bookPnumber)
			$('#multi-btn').html('<td><button id="booking-update-btn" class="btn">수정</button></td>'
								+'<td><button id="booking-delete-btn" class="btn">삭제</button></td>'
								+'<td><button id="booking-list-btn" class="btn">목록으로</button></td>')
			$('#booking-list-btn').click(e => {
				e.preventDefault()
				location.href = `${x}/move/bkg/list`
			})
			$('#booking-update-btn').click(e => {
				e.preventDefault()
	            $('#bName').html(`<input id="update-name" type="text" value="${d.bookName}"/>`)
	            $('#bEmail').html(`<input id="update-email" type="text" value="${d.bookEmail}"/>`)
	            $('#bPnumber').html(`<input id="update-pnumber" type="text" value="${d.bookPnumber}"/>`)
	            $('#multi-btn').html('<td><button id="confirm-btn" class="btn">확인</button></td>'
	            					 +'<td><button id="cancle-btn" class="btn">취소</button></td>')
	            $('#confirm-btn').click(e => {
	                e.preventDefault()
	                $.ajax({
	                    url: `${x}/bookings`,
	                    type: 'PUT',
	                    data: JSON.stringify({
	                        bookNum: d.bookNum,
	                        bookName: $('#update-name').val(),
	                        bookEmail: $('#update-email').val(),
	                        bookPnumber: $('#update-pnumber').val(),
	                    }),
	                    dataType: 'json',
	                    contentType: 'application/json',
	                    success: d => {
							alert(`수정 완료`)
	                        location.href = `${x}/move/bkg/detail`
	                    },
	                    error: e => {alert(`수정 실패: ${e}`)}
	                })
	            })
				$('#cancle-btn').click(e => {
					e.preventDefault()
					location.href = `${x}/move/bkg/detail`
				})
			})
			
			$('#booking-delete-btn').click(e => {
				e.preventDefault()
				$.ajax({
			        url: `${x}/bookings`,
			        type: 'DELETE',
			        data: JSON.stringify({
			            bookNum: d.bookNum
			        }),
			        dataType: 'json',
			        contentType: 'application/json',
			        success: d => {
						alert(`삭제 완료`)
		                location.href=`${x}/move/bkg/list`
			        },
			        error: e => { alert(`삭제 실패: ${e}`)}
			    })
			})
        })
	}
	return {booking, list, detail}
})()