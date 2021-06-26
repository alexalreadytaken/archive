// Создание уникального ключа для компоненов, для быстрого рендеринга айтемов в таблиицах.
const createKey = () => {
    return Math.random() + Math.floor(new Date().getTime());
  }

export default createKey;