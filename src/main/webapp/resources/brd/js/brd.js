var brd = brd || {}

brd.register = x => {
	$.ajax({
          url: `${x}/managers`,
          type: 'POST',
          data: JSON.stringify({
              email: $('#email').val(),
              password: $('#password').val()
          }),
          dataType: 'json',
          contentType: 'application/json',
          success: d => {
             location.href='/transfer/sym/mgr/index'
          },
          error: e => {
              console.log(`관리자등록 실패: ${e.responseText}`)
              location.href = '/move/cmm/404'
          }
      })
}