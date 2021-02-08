'use strict'
var shw = shw || {}
shw = (() => {
	const add = x => {
		alert(`등록하기 진입`)
		$.ajax({
			url: `${x}/shows`,
			type: `POST`,
			data: JSON.stringify({
				showNum: 0,
                title: $('#title').val(),
                period: $('#period').val(),
                time: $('#time').val(),
                venue: $('#venue').val(),
                admission: $('#admission').val(),
                price: $('#price').val(),
				host: $('#host').val(),
				management: $('#management').val(),
				inquiry: $('#inquiry').val()
			}),
			dataType: 'json',
            contentType: 'application/json',
            success: d => {
                if(d === 'SUCCESS'){
                    alert(`전시회 등록 완료`)
                    location.href=`${x}/move/shw/list`
                }else{
                    alert(`전시회 등록 실패`)
                    location.reload()
                }
            },
            error: e => { alert(`전시회 등록 실패: ${e}`)}
		})
	}
	
	const list = x => {
		$.getJSON(`${x}/shows/list`, d => {
	    	if(d.count != 0) {
	            const list = d.list
	            let tr = ''
	            let i = 0
	            for(; i < d.count; i++) {
	                tr+= '<tr>'
	                    +'<td class="text-center">'+list[i].showNum+'</td>'
	                    +'<td class="text-center"><a class="title" id="'+list[i].showNum+'" href="#" >'+list[i].title+'</a></td>'
	                    +'<td class="text-center">'+list[i].period+'</td>'
	                    +'<td class="text-center">'+list[i].time+'</td>'
	                    +'<td class="text-center">'+list[i].venue+'</td>'
	                    +'<td class="text-center">'+list[i].admission+'</td>'
	                    +'<td class="text-center">'+list[i].price+'</td>'
	                    +'<td class="text-center">'+list[i].host+'</td>'
	                    +'<td class="text-center">'+list[i].management+'</td>'
	                    +'<td class="text-center">'+list[i].inquiry+'</td>'
	                    +'</tr>'
	            }
	            $(`#shw-data`).html(tr)
	            $(`.title`).each(function(i) {
	                $(this).click(e => {
	                    e.preventDefault()
	                    localStorage.setItem('showNum', `${this.id}`)
						alert(`상세페이지 진입 성공`)
	                    location.href = `${x}/move/shows/detail`
	                })
	            })
	        }else {
	            alert(`목록 실패`)
	            $(".showNum").text('조회결과 없음')
	            $(".title").text('조회결과 없음')
	            $(".period").text('조회결과 없음')
	            $(".time").text('조회결과 없음')
	            $(".venue").text('조회결과 없음')
	            $(".admission").text('조회결과 없음')
	            $(".price").text('조회결과 없음')
	            $(".host").text('조회결과 없음')
	            $(".management").text('조회결과 없음')
	            $(".inquiry").text('조회결과 없음')
	        }
	    })        
	}
	/*
	const list = x => {	
		$.getJSON(`${x.ctx}/shows/list/${x.pageSize}/${x.pageNum}`, d => { 
			$(`<h3/>`)
			.attr({id: `title`})
			.text(`전시회 목록`)
			.appendTo(`#shw-data`)
			$(`<table/>`)
			.attr({id: `tab`})
			.css({width: `100%`})
			.appendTo(`#title`) 
			$(`<tr/>`).attr({id: `tr_1`}).appendTo(`#tab`)
			$.each(
				[`No`,`제목`,`기간`,`시간`,`장소`,`입장연령`,`가격`,`주최`,`주관`,`문의`], 
				(i,j) => {
				$(`<th>${j}</th>`).css({backgroundColor: `MediumPurple`, fontSize: `small`})
				.appendTo(`#tr_1`)
			})
			$.each(d.list, 
				(i, j) => {
						$(`<tr><td>${j.showNum}</td>
			   	    		<td>${j.title}</td>
			   	    		<td>${j.period}</td>
							<td>${j.time}</td>
							<td>${j.venue}</td>
							<td>${j.admission}</td>
							<td>${j.price}</td>
							<td>${j.host}</td>
							<td>${j.management}</td>
							<td>${j.inquiry}</td></tr>`)
							.css({padding: `15px`, textAlign: `left`, fontSize: `small`})
							.appendTo(`#tab`)
			})
			$(`<div/>`)
			.attr({id: `shw_page`})
			.addClass(`pagination`)
			.appendTo(`#shw-data`)
			const page = d.page
			
			function* range(start, end) {
			    yield start;
			    if (start === end) return;
			    yield* range(start + 1, end);
			}
			
			if(page.existPrev){
				$(`<a/>`)
				.attr({href: `#`})
				.text(`<<`)
				.css({backgroundColor: `White`})
				.appendTo(`#shw_page`)
				.click(e=>{
					e.preventDefault()
					$(`#shw-data`).empty()
					show.list({ctx: x.ctx, pageSize: `10`, pageNum: page.prevBlock})
				})
			}
			$.each(
				[...range(page.startPage, page.endPage)] ,
				 (i, j) => {
					$(`<a/>`)
						.attr({href: `#`})
						.css({backgroundColor: (j != page.pageNum) ? `White` : `Lavender`})
						.text(`${j}`)
						.appendTo(`#shw_page`)
						.click(e=>{
							e.preventDefault()
							$(`#shw-data`).empty()
							stu.list({ctx: x.ctx, pageSize: `10`, pageNum: j})
						})
			})
			if(page.existNext){
				$(`<a/>`)
				.attr({href: `#`})
				.css({backgroundColor: `White`})
				.text(`>>`)
				.appendTo(`#shw_page`)
				.click(e=>{
					e.preventDefault()
					$(`#shw-data`).empty()
					stu.list({ctx: x.ctx, pageSize: `10`, pageNum: page.nextBlock})
				})
			}
		})
	}
	*/
	const detail = x => {
	$.getJSON(`${x}/shows/${localStorage.getItem(`showNum`)}`, d => {
            $('#showNum').text(d.showNum)
            $('#title').text(d.title)
            $('#period').text(d.period)
            $('#time').text(d.time)
            $('#venue').text(d.venue)
            $('#admission').text(d.admission)
            $('#price').text(d.price)
            $('#host').text(d.host)
            $('#management').text(d.management)
            $('#inquiry').text(d.inquiry)

            $('#update-btn').click(e => { 
                $('#title').html('<input id="update-title" type="text" value="'+d.title+'"/>')
                $('#period').html('<input id="update-period" type="text" value="'+d.period+'"/>')
                $('#time').html('<input id="update-time" type="text" value="'+d.time+'"/>')
                $('#venue').html('<input id="update-venue" type="text" value="'+d.venue+'"/>')
                $('#admission').html('<input id="update-admission" type="text" value="'+d.admission+'"/>')
                $('#price').html('<input id="update-price" type="text" value="'+d.price+'"/>')
                $('#host').html('<input id="update-host" type="text" value="'+d.host+'"/>')
                $('#management').html('<input id="update-management" type="text" value="'+d.management+'"/>')
                $('#inquiry').html('<input id="update-inquiry" type="text" value="'+d.inquiry+'"/>')
                $('#update').text('수정 화면')
                $('#toggle').html('<button id="confirm-btn">수정 확인</button>')
                $('#confirm-btn').click(e => {
                    e.preventDefault()
                    $.ajax({
                        url: `${x}/shows`,
                        type: 'PUT',
                        data: JSON.stringify({
                            showNum: d.showNum,
                            title: $('#update-title').val(),
                            period: $('#update-period').val(),
                            time: $('#update-time').val(),
                            venue: $('#update-venue').val(),
                            admission: $('#update-admission').val(),
                            price: $('#update-price').val(),
                            host: $('#update-host').val(),
                            management: $('#update-management').val(),
                            inquiry: $('#update-inquiry').val()
                        }),
                        dataType: 'json',
                        contentType: 'application/json',
                        success: d => {
                            if(d.message === 'SUCCESS'){
                                location.href = `${x}/move/shows/detail`
                            }else{
                                alert(`수정 실패`)
                            }
                        },
                        error: e => {alert(`수정 에러 발생: ${e}`)}
                    })
                })
            })

            $('#delete-btn').click(e => {
                e.preventDefault()
                $.ajax({
                    url: `${x}/shows`,
                    type: `DELETE`,
                    data: JSON.stringify({
                        showNum: d.showNum
                    }),
                    dataType: 'json',
                    contentType: 'application/json',
                    success: d => {
                        if(d.message === 'SUCCESS') {
							alert(`삭제 성공`)
                            location.href = `${x}/move/shows/list`
                        }else {
                            alert(`삭제 실패`)
                        }
                    },
                    error: e => {
                        alert(`삭제 에러 발생: ${e}`)
                    }
                })
            })
        })
	}
	
	return {add, list, detail}
})()
