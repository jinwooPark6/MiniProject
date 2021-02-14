'use strict'

var brd = brd || {}
brd = (() => {
	const write = x => {
		alert(`게시글 등록하기`)
		$.ajax({
			url: `${x}/boards`,
			type: `POST`,
			data: JSON.stringify({
				boardNum: 0,
			title: $('#title').val(),
			content: $('#content').val(),
			date: $('#date').val(),
			id: $('#id').val()
			}),
			dataType: 'json',
			contentType: 'application/json',
			success: d=> {

					alert(`게시글 등록 완료`)
					location.href=`${x}/move/brd/list`
			},
			error: e => {alert(`게시글 등록 실패: ${e}`)
			location.reload()
			}
		})
	}
	
	const list = x => {	
	$.getJSON(`${x}/boards/list`, d => { 
		$(`<h3/>`)
		.attr({id: `title`})
		.appendTo(`#brd-data`)
		$(`<table/>`)
		.attr({id: `tab`})
		.css({width: `100%`})
		.appendTo(`#title`) 
		$(`<tr/>`).attr({id: `tr_1`}).appendTo(`#tab`)
		$.each(
			[`No`,`제목`,`내용`,`날짜`,`작성자`], 
		    (i, j) => {
			$(`<th>${j}</th>`).css({backgroundColor: `pink`, fontSize: `19px`})
			.appendTo(`#tr_1`)
		})
		$.each(d,
			(i, j) => {
				
			$(`<tr><td>${j.boardNum}</td>
					<td><a class="title" href="#" id="${j.boardNum}">${j.title}</a></td>
		   	    		<td>${j.content}</td>
						<td>${j.date}</td>
						<td>${j.id}</td></tr>`)
						.css({padding: `20px`, textAlign: `center`, fontSize: `13px`, height: `25px`})
						.appendTo(`#tab`)
		})
		$(`.title`).each(function(){
                    $(this).click(e => {
                        e.preventDefault()
                        localStorage.setItem(`boardNum`, `${this.id}`)
						alert(`상세보기`)
                        location.href=`${x}/move/brd/detail`
                    })
                })
			})
		}
	const detail = x => {
        $.getJSON(`${x}/boards/${localStorage.getItem(`boardNum`)}`, d => {
            $(`#boardNum`).text(d.boardNum)
            $(`#title`).text(d.title)
            $(`#content`).text(d.content)
            $(`#date`).text(d.date)
            $(`#id`).text(d.id)

			 $('#update-btn').click(e => { 
                $('#title').html(`<input id="update-title" type="text" value="${d.title}"/>`)
                $('#content').html(`<input id="update-content" type="text" value="${d.content}"/>`)
                $('#date').html(`<input id="update-date" type="text" value="${d.date}"/>`)
                $('#id').html(`<input id="update-id" type="text" value="${d.id}"/>`)
                $('#update').text('수정 화면')
                $('#update-btn').html('<button id="confirm-btn">수정 확인</button>')

	            $('#confirm-btn').click(e => {
	                e.preventDefault()
	                $.ajax({
	                    url: `${x}/boards`,
	                    type: 'PUT',
	                    data: JSON.stringify({
	                        boardNum: d.boardNum,
							title: $('#update-title').val(),
	                        content: $('#update-content').val(),
	                        date: $('#update-date').val(),
	                        id: $('#update-id').val()
	                    }),
	                    dataType: 'json',
	                    contentType: 'application/json',
	                    success: d => {
							alert(`수정 완료`)
	                        location.href = `${x}/move/brd/detail`
	                    },
	                    error: e => {alert(`수정 실패: ${e}`)}
	                })
	            })
		})
			
            $('#delete-btn').click(e => {
                e.preventDefault()
                $.ajax({
                    url: `${x}/boards`,
                    type: `DELETE`,
                    data: JSON.stringify({
                        boardNum: d.boardNum
                    }),
                    dataType: 'json',
                    contentType: 'application/json',
                    success: d => {
							alert(`삭제 성공`)
                            location.href = `${x}/move/brd/list`             
                    },
                    error: e => {
                        alert(`삭제 에러 발생: ${e}`)
                    }
                })
            })
        })
	}
	
	return {write, list, detail}
})()