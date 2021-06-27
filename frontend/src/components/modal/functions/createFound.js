import urlConfig from '../../../urlConfig.json'

function createFound () { 
  let fundNumber = document.getElementById('fundNumberCreate');
  let fundLetter = document.getElementById('fundLetterCreate');
  let fundName = document.getElementById('fundNameCreate');
  let newFundDate = document.getElementById('date');
  let arrOldNames = [];

  if (fundNumber.value.length === 0 || fundLetter.value.length === 0 || fundName.value.length === 0 || newFundDate.value.length === 0) {
    alert ('Введены не все значения!');
  } else {
    // Сбор данных для отправки 
    // сбор старых названий
    let oldNameInput = document.querySelectorAll('#oldName-input');
    let oldDateInput = document.querySelectorAll('#oldName-date');

    for (let i = 0; i < oldNameInput.length; i++) {
      let oldNameObj = {}
      if (oldNameInput[i].value.length > 0 && oldDateInput[i].value.length > 0) {
        oldNameObj = {
          fromDate: oldDateInput[i].value,
          name: oldNameInput[i].value
        }
        arrOldNames.push(oldNameObj)
      }
    }

    // Готовый для отправки объект
  let createData = {}
  if (arrOldNames.length === 0) {
    createData = {
    number: fundNumber.value,
    letter: fundLetter.value,
    currentFundName: {
      fromDate: newFundDate.value,
      name: fundName.value,
      }
    }
  } else {
    createData = {
    number: fundNumber.value,
    letter: fundLetter.value,
    currentFundName: {
      fromDate: newFundDate.value,
      name: fundName.value,
    },
    oldNames: arrOldNames
    }
  }
  console.log(createData);
  alert('Фонд успешно создан!')
  }

  
  fetch('http://' + urlConfig.url.ip + ':' + urlConfig.url.port + '/fund', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(createData)
  }).then(res => res.json())
    .then(res => console.log(res))
    .catch(err => {throw new Error(err)});
}


export default createFound;