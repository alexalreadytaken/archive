import urlConfig from '../../urlConfig.json'

function search(){
  let inputFundNumber = document.getElementById('fundNumber');
  let inputFundName = document.getElementById('fundName');
  let listFundNumbers = document.getElementById('listFundNumbers');
  let listFundNames = document.getElementById('listFundNames');

  fetch('http://' + urlConfig.url.ip + ':' + urlConfig.url.port + '/fund')
  .then(res => res.json())
  .then(json => testrazdacha(json))
  .catch(() => console.error('error searchFund.js'));

  function testrazdacha(json) {
    getFundNamesForInputList (json);
    getFundNumbersForInputList(json)
  }

  function getFundNumbersForInputList(json) {
    //Удаление старых options с именами фондов для того чтобы внести в datalist новые (потом сделаем культурнее)
    let deleteOptions = listFundNumbers.lastElementChild;
    while (deleteOptions) {
      listFundNumbers.removeChild(deleteOptions);
      deleteOptions = listFundNumbers.lastElementChild;
    }
    // Создание options с номерами фондов в datalist
    for (let i = 0; i < json.length; i++) {
      let fundNumber = json[i].number;
      let newOptionNumber = document.createElement('option');
      newOptionNumber.value = fundNumber;
      console.log(newOptionNumber);
      listFundNumbers.appendChild(newOptionNumber);
    }
  }

  function getFundNamesForInputList (json) {
    //Удаление старых options с именами фондов для того чтобы внести в datalist новые (потом сделаем культурнее)
    let deleteOptions = listFundNames.lastElementChild;
    while (deleteOptions) {
      listFundNames.removeChild(deleteOptions);
      deleteOptions = listFundNames.lastElementChild;
    }
    // Создание options с именами фондов в datalist
    for (let i = 0; i < json.length; i++) {
      let fundName = json[i].currentFundName.name;
      let newOptionName = document.createElement('option');
      newOptionName.value = fundName;
      listFundNames.appendChild(newOptionName);
    }
  }
}


export default search;


