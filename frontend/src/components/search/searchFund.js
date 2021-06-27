import urlConfig from '../../urlConfig.json'

function search(){
  let inputFundNumber = document.getElementById('fundNumber');
  let inputFundName = document.getElementById('fundName');
  console.log(inputFundName.value);


  // fetch('http://' + urlConfig.url.ip + ':' + urlConfig.url.port + '/fund')
  // .then(res => res.json())
  // .then(json => console.log(json))
  // .catch(() => console.error('Что то не так...'));
}


export default search;


