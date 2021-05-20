import './App.css';
import React,{useState} from 'react';
import Header from './header/header.jsx';
import Search from './search/search.jsx';
import MainContent from './main-content/main-content.jsx';
import InventoryTable from './main-content/main-components/main-inventory-table/main-inventory-table.jsx'


function App() {

  let [state, setState] = useState([{id:1}]);
  console.log(state);

  function se () {
    setState((prev) =>  [...prev, ...[{id:2}, {id:3}]])
  console.log(state);
  }

  window.onclick = function() {
    setState((prev) =>  [...prev, ...[{id:2}, {id:3}]])
  console.log(state);
  };

  return (
    // Этот див оберта для того чтобы реакт понимал так как все теги должны быть в нутри одного главного
    <div>
      <Header/>
        <div className="container">
          <Search/>
          <MainContent>
            <InventoryTable></InventoryTable>
          </MainContent>
        </div>
    </div>
  );
}

export default App;
