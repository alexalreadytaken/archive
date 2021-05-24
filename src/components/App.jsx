import './App.css';
import React,{useState} from 'react';
import Header from './header/header.jsx';
import Search from './search/search.jsx';
import MainContent from './main-content/main-content.jsx';
import InventoryTable from './main-content/main-components/main-inventory-table/main-inventory-table.jsx';
import TablesForAffairs from './main-content/main-components/tables-for-affairs/tables-for-affairs.jsx';
import AffairsTable from './main-content/main-components/tables-for-affairs/affairs-table/main-affairs-table.jsx';


function App() {
  return (
    // Этот див обертка для того чтобы реакт понимал так как все теги должны быть внутри одного главного
    <div>
      <Header/>
        <div className="container">
          <Search/>
          <MainContent>              
            <InventoryTable/>
            <TablesForAffairs>
              <AffairsTable/>
            </TablesForAffairs>
          </MainContent>
        </div>
    </div>
  );
}

export default App;
