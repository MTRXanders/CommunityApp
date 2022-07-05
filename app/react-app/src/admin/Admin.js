import  { Admin } from 'react-admin'
import dataProvider  from './services/DataProvider'
// import  authProvider  from './services/AuthProvider'
import UserCreate from './pages/UserCreate'
import LoginPage from './pages/LoginPage'
import { Resource } from 'react-admin'
import { UserList} from './pages/UserList'
import UserShow from './pages/UserShow'

export default function App() {

return (
<Admin basename="/admin" loginPage={LoginPage} dataProvider={dataProvider}>
    <Resource name='user' show={UserShow} list={UserList} create={UserCreate} ></Resource>  
</Admin>)
}